package DataMatching.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ServiceDiscoveryClient {
    @Autowired
    private DiscoveryClient discoveryClient;

    public UserData getData(int customerId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances =
                discoveryClient.getInstances("company_a");
        String serviceUri = String.format("%s/companya/%d"
                , instances.get(0).getUri().toString(), customerId);
        ResponseEntity<UserData> restExchange =
                restTemplate.exchange(serviceUri, HttpMethod.GET,null, UserData.class);

        return restExchange.getBody();
    }
}
