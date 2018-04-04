package ru.bellintegrator.denisov.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.view.ResponseView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationControllerTest {
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/organization";
    
    @Test
    public void testGetAllOrgWithFiltration() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String body = "{\"name\" : \"MC\"}";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }
    
    @Test
    public void testGetOrganization() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "//1", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }
    
    @Test
    public void saveOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String body = "{\"name\" : \"newName\"}";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/save", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getResult());
    }
    
    @Test
    public void updateOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String body = "{\"id\" : \"2\"," 
                + "\"name\" : \"newSomeName\"" 
                + "}";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/update", HttpMethod.PUT, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getResult());
    }
    
    @Test
    public void deleteOrganization() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "//1", HttpMethod.DELETE, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getResult());
    }
    
}
