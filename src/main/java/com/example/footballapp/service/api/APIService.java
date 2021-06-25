package com.example.footballapp.service.api;

import com.example.footballapp.dto.response.LeagueResponse;
import com.example.footballapp.dto.response.TeamResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class APIService {
    @Value("${header_key_name}")
    private String keyName;

    @Value("${header_key_value}")
    private String keyValue;

    @Value("${header_host_name}")
    private String hostName;

    @Value("${header_host_value}")
    private String hostValue;

    @Value("${header_use_query_name}")
    private String useQueryName;

    @Value("${header_use_query_value}")
    private String useQueryValue;

    @Value("${rapid_api_url}")
    private String apiUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<Object> getDataFromRapid(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(keyName, keyValue);
        headers.add(hostName, hostValue);
        headers.add(useQueryName, useQueryValue);
        HttpEntity<String> entity = new HttpEntity<>("headers", headers);
        ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, Object.class);
        return responseEntity;
    }

    public LeagueResponse getLeagueFromRapid(String name, String country) {
        ResponseEntity<Object> objects = getDataFromRapid(apiUrl + "/v3/leagues?name=" + name + "&country=" + country + "&current=true");
        LinkedHashMap<String, Object> bodyOfRequest = (LinkedHashMap<String, Object>) objects.getBody();
        List<Object> responseOfBodyRequest = (List<Object>) bodyOfRequest.get("response");
        LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) responseOfBodyRequest.get(0);
        return objectMapper.convertValue(data.get("league"), LeagueResponse.class);
    }
}
