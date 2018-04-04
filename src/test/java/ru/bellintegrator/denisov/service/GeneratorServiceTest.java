package ru.bellintegrator.denisov.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class GeneratorServiceTest {
    
    @Autowired
    GeneratorService generator;
    
    @Test
    public void testEncode() {
        String beforeEncode = "stringForEncode";
        String afterEncode = generator.encode(beforeEncode);
        Assert.assertNotNull(afterEncode);
        Assert.assertNotEquals(beforeEncode, afterEncode);
    }

    @Test
    public void testGenerateString() {
        String generatedString = generator.generateString();
        Assert.assertNotNull(generatedString);
    }
    
}
