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
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
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
        
        OrganizationFilterView body = new OrganizationFilterView();
        body.name = "MC";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "[{id=1, name=MC, isActive=true}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void testGetOrganization() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "{id=1, name=MC, fullName=MacDonalds corp., inn=123456789, kpp=12345678, address=Red Place, "
                + "phone=8(911) 123-34-45, isActive=true}";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void saveOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        OrganizationView body = new OrganizationView();
        body.name = "newName";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/save", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Boolean result = responseView.getResult();
        Assert.assertNotNull(result);
        
        Boolean waitingResponse = true;
        Assert.assertEquals(waitingResponse, result);
    }
    
    @Test
    public void updateOrganization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        OrganizationView body = new OrganizationView();
        body.id = "2";
        body.name = "newSomeName";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/update", HttpMethod.PUT, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Boolean result = responseView.getResult();
        Assert.assertNotNull(result);
        
        Boolean waitingResponse = true;
        Assert.assertEquals(waitingResponse, result);
    }
    
    @Test
    public void deleteOrganization() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/3", HttpMethod.DELETE, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Boolean result = responseView.getResult();
        Assert.assertNotNull(result);
        
        Boolean waitingResponse = true;
        Assert.assertEquals(waitingResponse, result);
    }
    
}
