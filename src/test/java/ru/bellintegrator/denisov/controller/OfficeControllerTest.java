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
import ru.bellintegrator.denisov.view.OfficeFilterView;
import ru.bellintegrator.denisov.view.OfficeView;
import ru.bellintegrator.denisov.view.ResponseView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeControllerTest {
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/office";
   
    @Test
    public void testGetOfficeById() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "{id=1, name=Office #1, address=Office #1 address, phone=8(911) 543-34-45, isActive=true}";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void testGetAllOfficesWithFiltration() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        OfficeFilterView body = new OfficeFilterView();
        body.orgId = "1";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "[{id=1, name=Office #1, isActive=true}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void saveOffice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        OfficeView body = new OfficeView();
        body.orgId = "1";
        body.name = "someName";
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
    public void updateOffice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        OfficeView body = new OfficeView();
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
    public void deleteOffice() {
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
