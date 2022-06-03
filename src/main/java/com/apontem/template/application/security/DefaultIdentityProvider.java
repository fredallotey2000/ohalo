package com.apontem.template.application.security;

import com.apontem.template.application.security.exception.ForbiddenAccess;
import com.apontem.template.application.security.exception.UnAuthorizedAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Duration;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Slf4j
public class DefaultIdentityProvider implements IdentityProvider {
    @Value( "${provider.identity.url}" )
    private String url;
    @Value( "${provider.identity.connectionTimeoutMilli}" )
    private long connectionTimeout;
    private  final RestTemplate restTemplate;

    public DefaultIdentityProvider() {
        String apiKey = ""; // call a service to get the api key from some secrets vault
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        this.restTemplate = restTemplateBuilder
                .errorHandler(new HttpClientResponseErrorHandler())
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .defaultHeader("x-api-key", apiKey)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    public Identity getIdentity(String token) throws UnAuthorizedAccess, ForbiddenAccess {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", String.format("Bearer %s", token));
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Identity> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                Identity.class);

        log.info("Call to IdentityProvider.getIdentity returned response status {}.", responseEntity.getStatusCode().value());
        if(responseEntity.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) throw new UnAuthorizedAccess();
        if(responseEntity.getStatusCode().equals(HttpStatus.FORBIDDEN)) throw new ForbiddenAccess();
        return responseEntity.getBody();
    }

    static class HttpClientResponseErrorHandler implements ResponseErrorHandler {
        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            return (
                    response.getStatusCode().series() == CLIENT_ERROR
                            || response.getStatusCode().series() == SERVER_ERROR);
        }

        @Override
        public void handleError(ClientHttpResponse response) {
            // Do nothing.
        }
    }
}
