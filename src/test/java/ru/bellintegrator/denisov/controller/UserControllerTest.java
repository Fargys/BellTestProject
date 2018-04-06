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
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserControllerTest {
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888/api/user";
    
    @Test
    public void testGetUser() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/1", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "{id=1, firstName=Walter, secondName=White, middleName=Hartwell, position=Cook, " 
                + "phone=8(911) 737-35-25, docName=Passport, docNumber=1234567, docDate=2018-03-15, citizenshipName=Russia, " 
                + "citizenshipCode=10, isIdentified=true, officeId=1}";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void testGetAllUsersWithFiltration() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        UserFilterView body = new UserFilterView();
        body.officeId = "1";
        body.firstName = "Walter";
        HttpEntity entity = new HttpEntity<>(body, headers);
        
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "/list", HttpMethod.POST, entity, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        
        ResponseView responseView = responseEntity.getBody();
        Assert.assertNotNull(responseView);
        
        Object data = responseView.getData();
        Assert.assertNotNull(data);
        
        String waitingResponse = "[{id=1, firstName=Walter, secondName=White, middleName=Hartwell, position=Cook}]";
        Assert.assertEquals(waitingResponse, data.toString());
    }
    
    @Test
    public void saveUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        UserView body = new UserView("someName", "1");
        body.firstName = "someName";
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
    public void updateUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserView body = new UserView("2", "newSomeName", "1");
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
    public void deleteUser() {
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
