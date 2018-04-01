package ru.bellintegrator.denisov.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.denisov.Application;
import ru.bellintegrator.denisov.service.OrganizationService;
import ru.bellintegrator.denisov.view.OrganizationFilterView;
import ru.bellintegrator.denisov.view.OrganizationView;
import ru.bellintegrator.denisov.view.ResponseView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationControllerIT {
    RestTemplate restTemplate = new RestTemplate();
    String patternURL = "http://localhost:8888//api//organization";
    
    
//    @Test
//    public void testGetAllOrgWithFiltration() {
//        ResponseEntity< List<OrganizationView> > responseEntity = 
//                restTemplate.exchange(patternURL + "//list", HttpMethod.POST, null, 
//                        new ParameterizedTypeReference< List<OrganizationView> >(){
//                        });
//        List<OrganizationView> listOrgView = responseEntity.getBody();
//        
//    }
    
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
    public void updateOrganization() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("name", "newName");
//        
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<ResponseView> responseEntity = restTemplate.postForEntity( patternURL + "//update", request , ResponseView.class );
//        
//        ResponseView responseView = responseEntity.getBody();
//        
//        System.out.println(responseView.toString());
    }
    
    
    @Test
    public void deleteOrganization() {
        ResponseEntity<ResponseView> responseEntity = 
                restTemplate.exchange(patternURL + "//1", HttpMethod.DELETE, null, 
                        new ParameterizedTypeReference<ResponseView>(){
                        });
        ResponseView responseView = responseEntity.getBody();
        
        System.out.println("---------------------");
        System.out.println(responseView.toString());
        System.out.println("---------------------");
        
//        Assert.assertNotNull(responseView);
//        Assert.assertNotNull(responseView.getData());
    }
    
    
    
//    @Test
//    public void test() {
//        //test get organiztion
//        OrganizationView view = orgService.organization("1");
//        Assert.assertNotNull(view);
//        
//        //test update
//        String newName = "newName";
//        view.name = newName;
//        orgService.update(view);
//        OrganizationView updatedView = orgService.organization("1");
//        Assert.assertEquals(updatedView.name, newName);
//        
//        //test save
//        OrganizationView saveView = new OrganizationView();
//        saveView.name = "testName";
//        saveView.fullName = "testFullName";
//        saveView.inn = 12345;
//        saveView.kpp = 1234;
//        saveView.address = "testAddress";
//        saveView.phone = "testPhone";
//        saveView.isActive = true;
//        orgService.save(saveView);
//        
//        test get organizations
//        OrganizationFilterView filter = new OrganizationFilterView();
//        filter.name = "test";
//        List<OrganizationView> list = orgService.organizations(filter);
//        Assert.assertNotNull(list);
//        Assert.assertFalse(list.isEmpty());
//    }
    
}
