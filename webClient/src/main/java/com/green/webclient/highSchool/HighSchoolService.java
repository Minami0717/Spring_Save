package com.green.webclient.highSchool;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.webclient.highSchool.model.SchoolDto;
import com.green.webclient.highSchool.model.SchoolVo;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HighSchoolService {
    private final String myApiKey;
    private final WebClient webClient;
    private final HighSchoolMapper mapper;

    public HighSchoolService(@Value("${my-api.key}") String myApiKey, HighSchoolMapper mapper) {
        this.myApiKey = myApiKey;
        this.mapper = mapper;
        TcpClient tcpClient = TcpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(5000));
                    connection.addHandlerLast(new WriteTimeoutHandler(5000));
                });

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(config -> config.defaultCodecs().maxInMemorySize(-1))
                .build();

        this.webClient = WebClient.builder()
                .exchangeStrategies(exchangeStrategies)
                .baseUrl("https://open.neis.go.kr/hub")
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public List<SchoolDto> getSchoolNm() {
        String json = webClient.get().uri(uriBuilder -> uriBuilder.path("/schoolInfo")
                        .queryParam("KEY", myApiKey)
                        .queryParam("Type", "json")
                        .queryParam("pIndex", 1)
                        .queryParam("pSize", 500)
                        .queryParam("ATPT_OFCDC_SC_CODE", "D10")
                        .queryParam("SCHUL_KND_SC_NM", "고등학교")
                        .build()
                ).retrieve().bodyToMono(String.class)
                .block();

        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<SchoolVo> schoolList;
        List<SchoolDto> schoolInfoList = new ArrayList<>();
        try {
            JsonNode jsonNode = om.readTree(json);
            schoolList = om.convertValue(jsonNode.at("/schoolInfo/1/row"), new TypeReference<>() {});
            for (SchoolVo vo : schoolList) {
                if ("일반고".equals(vo.getType()) || "자율고".equals(vo.getType())) {
                    schoolInfoList.add(new SchoolDto(vo.getNm(), vo.getCode()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info(String.valueOf(schoolInfoList.size()));
        mapper.insSchool(schoolInfoList);
        return schoolInfoList;
    }
}
