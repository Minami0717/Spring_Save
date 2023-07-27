package com.example.messagetest;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestService {
    public int sendSMS(String phoneNum) {
        int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);
        String api_key = "NCS0VK412LRMRST6";
        String api_secret = "PKWQJNPODHNHIU7KHFVIJDN4PCS0OXWE";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<>();
        params.put("to", phoneNum);    // 수신전화번호
        params.put("from", phoneNum);    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "[TEST] 인증번호는" + "["+randomNumber+"]" + "입니다."); // 문자 내용 입력
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
        return randomNumber;
    }
}
