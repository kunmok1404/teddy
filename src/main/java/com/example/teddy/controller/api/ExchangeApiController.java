package com.example.teddy.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.MapUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class ExchangeApiController {

    @GetMapping("/api/exchange/list")
    public ResponseEntity<?> getExchangeList(String dt) {
      String DATE = ""; // 조회 날짜
//      if(MapUtils.isEmpty(paramMap)) {
//          Date day = new Date();
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//          DATE = sdf.format(day);
//      }
      if(dt == null || dt == "") {
          Date day = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
          DATE = sdf.format(day);
      }
//      DATE = (String)paramMap.get("DATE");
      DATE = dt;
      StringBuffer str = new StringBuffer();
      String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
      String key = "k4ShXRlwUpkBgt4NZgQD8bthi0P9rbjN";
      String type = "AP01";
      str.append(url);
      str.append("?authkey=");
      str.append(key);
      str.append("&searchdate=");
      str.append(DATE);
      str.append("&data=");
      str.append(type);
      String strUrl = str.toString();

        // header 설정
      HttpHeaders httpHeaders = new HttpHeaders();
      HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<?> resultMap = restTemplate.exchange(strUrl, HttpMethod.GET, httpEntity, Object.class);
      System.out.println("resultMap =" + resultMap);
      return resultMap;
    }
}
