package com.green.jpaexam.provider;

import com.green.jpaexam.entity.ProviderEntity;
import com.green.jpaexam.provider.model.*;
import com.green.jpaexam.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderRepository rep;

    public ProviderInsVo save(ProviderInsDto dto) {
        ProviderEntity provider = rep.save(ProviderEntity.builder()
                .name(dto.getName())
                .build());

        return ProviderInsVo.builder()
                .id(provider.getId())
                .name(provider.getName())
                .createdAt(provider.getCreatedAt())
                .build();
    }

    public ProviderUpdVo update(ProviderUpdDto dto) {
        ProviderEntity provider = rep.findById(dto.getId()).get();
        provider.setName(dto.getName());
        rep.save(provider);

//        ProviderEntity provider = rep.save(ProviderEntity.builder()
//                .name(dto.getName())
//                .id(dto.getId())
//                .build());

        return ProviderUpdVo.builder()
                .id(provider.getId())
                .name(provider.getName())
                .updatedAt(provider.getUpdatedAt())
                .build();
    }

    public int delete(Long id) {
        Optional<ProviderEntity> opt = rep.findById(id);
        if (opt.isEmpty()) {
            return 0;
        }

        rep.deleteById(id);
        return 1;
    }

    public List<ProviderSelVo> findAll() {
        List<ProviderEntity> entityList = rep.findAll(Sort.by(Sort.Direction.ASC, "name"));
        return entityList.stream().map(providerEntity -> ProviderSelVo.builder()
                .id(providerEntity.getId())
                .name(providerEntity.getName())
                .build()).toList();
    }
}
