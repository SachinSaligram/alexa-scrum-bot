package com.nmvk.config;

import com.atlassian.httpclient.apache.httpcomponents.DefaultHttpClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Spring config.
 *
 * @author raghav
 */
@Configuration
public class Config {
    public static final String username = "scrumuser2017@gmail.com";

    public static final String password = "scrumster2017";

    public static final String AUTHORIZATION_HEADER = "Authorization";
    /**
     * Jira client.
     *
     * @return Jira rest client.
     */
    @Bean
    public JiraRestClient getClient() throws URISyntaxException{
        JiraRestClientFactory restClientFactory = new AsynchronousJiraRestClientFactory();

        JiraRestClient restClient = restClientFactory.createWithBasicHttpAuthentication(new URI("https://scrumster.atlassian.net"),
                username,password);
        return restClient;
    }

    /**
     * Get default httpclient.
     * @return HttpClient.
     */
    @Bean
    public HttpClient getHttpClient() {
        HttpClient httpclient = HttpClientBuilder.create().build();
        return httpclient;
    }

    @Bean
    public Jedis getJedisClient() {
        Jedis jedis = new Jedis("54.172.210.127",6379);
        return jedis;
    }
}
