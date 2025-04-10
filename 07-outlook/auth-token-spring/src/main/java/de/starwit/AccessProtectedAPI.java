package de.starwit;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Service
public class AccessProtectedAPI {

    private Logger log = LoggerFactory.getLogger(AccessProtectedAPI.class);

    // idp that issues access tokens
    @Value("${api.access.idpurl}")
    private String authUrl;

    // the actual API we want to access
    @Value("${api.access.url}")
    private String apiURL;

    @Value("${api.access.username}")
    private String username;

    @Value("${api.access.password}")
    private String password;

    @Value("${api.access.clientid}")
    private String clientid;

    // access token, that we get from IdP
    private String token = null;

    // Token have a validity timespan, hence creation timestamp
    private LocalDateTime tokenTimeStamp;

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper mapper;

    @PostConstruct
    public void init() {
        log.info("Starting accessing protected URL");
        // get a token to access protected API
        getAccessToken();

        if(token != null) {
            // do actual REST call
            callSampleAPI();
        }
    }
    
    private void getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("realm", "default");
        map.add("client_id", clientid);
        map.add("grant_type", "password"); 
        map.add("username", username);
        map.add("password", password);        

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        HttpEntity<String> response;
        try {
            response = restTemplate.postForEntity(authUrl, request, String.class);
        } catch (HttpClientErrorException e) {
            log.error("Can't get access token for user " + username + " with error: " + e.getMessage());
            token = null;
            return;
        }

        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            AuthTokenResponse authResponse = mapper.readValue(response.getBody(), AuthTokenResponse.class);
            token = authResponse.getAccessToken();
            tokenTimeStamp = LocalDateTime.now();
            log.info("Token succesfully loaded");
        } catch (JsonProcessingException e) {
            log.error("Can't parse auth response " + e.getMessage());
        }
    } 
    
    private void callSampleAPI() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        log.info("Try to access " + apiURL);
        
        try {
            URI uri = new URI(apiURL);
            var entity = RequestEntity.get(uri).headers(headers).build();
            HttpEntity<String> response = restTemplate.exchange(entity, String.class);
            log.info("Response from protected API: " + response.getBody());
        } catch (HttpClientErrorException e) {
            log.error("Can't access protected API with error: " + e.getMessage());
            return;
        } catch (URISyntaxException e) {
            log.error("URI syntax broken " + e.getMessage());
        }
    }
}
