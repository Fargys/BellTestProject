package ru.bellintegrator.denisov.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
public class ReferenceControllerTest {
    
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888//api";
    
    @Test
    public void testGetAllDocuments() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "//docs", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
//        Assert.assertNotNull(responseView);
//        Assert.assertNotNull(responseView.getData());
    }
    
    @Test
    public void testGetAllCitizenships() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "//countries", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        Assert.assertNotNull(responseView);
        Assert.assertNotNull(responseView.getData());
    }
    
}
