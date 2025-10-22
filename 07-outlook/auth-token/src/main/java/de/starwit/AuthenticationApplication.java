package de.starwit;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

public class AuthenticationApplication {

    Logger log = LoggerFactory.getLogger(AuthenticationApplication.class.getName());

    Properties config = new Properties();

    String token = null;

    public static void main(String[] args) {
        var app = new AuthenticationApplication();
        app.getAccessToken();
        app.accessAPI();
    }

    public AuthenticationApplication() {
        try (InputStream in = AuthenticationApplication.class.getClassLoader().getResourceAsStream("application.properties")) {
            if(in != null) {
                config.load(in);
            } else {
                log.error("Can't find property file");
                System.exit(1);
            }
            
        } catch (IOException e) {
            log.error("Can't load property file, exiting " + e.getMessage());
            System.exit(1); // exit with error status
        }
    }

    private void getAccessToken() {
        String idpurl = config.getProperty("api.access.idpurl");
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(idpurl);

        final List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("realm", "default"));
        params.add(new BasicNameValuePair("client_id", "aicockpit"));
        params.add(new BasicNameValuePair("grant_type", "password"));
        params.add(new BasicNameValuePair("username", "admin"));
        params.add(new BasicNameValuePair("password", "adminadmin"));
        request.setEntity(new UrlEncodedFormEntity(params));

        try {
			String response = client.execute(request, new BasicHttpClientResponseHandler());
            log.info(response);
            token = extractToken(response);
		} catch (IOException e) {
			log.error("Can't get access token " + e.getMessage());
		}
    }

    private String extractToken(String response) {
        ObjectMapper om = new ObjectMapper();
        JsonNode node;
		try {
			node = om.readTree(response);
            if(node.has("access_token")) {
                return node.get("access_token").asText();
            }            
		} catch (JsonProcessingException e) {
			log.error("Can't parse response " + e.getMessage());
		}
        return null;
    }

    private void accessAPI() {
        if(token == null) {
            log.error("No token, can't access API");
            return;
        }

        String apiurl = config.getProperty("api.access.url");
        HttpGet request = new HttpGet(apiurl);
        request.setHeader("Authorization", "Bearer " + token);

        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
			String response = client.execute(request, new BasicHttpClientResponseHandler());
            log.info(response);
		} catch (IOException e) {
			log.error("Can't access API " + e.getMessage());
		}
    }

}