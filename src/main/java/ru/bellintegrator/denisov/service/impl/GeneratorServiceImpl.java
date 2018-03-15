package ru.bellintegrator.denisov.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
import java.util.logging.Level;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.service.GeneratorService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class GeneratorServiceImpl implements GeneratorService {
    
    @Override
    public String encode(String stringForEncode) {
        byte[] digest = null;
        
        try {
            MessageDigest encoder = MessageDigest.getInstance("SHA-256");
            digest = encoder.digest(stringForEncode.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new String(Base64.getEncoder().encode(digest));
    }

    @Override
    public String generateString() {
        String generatedString = UUID.randomUUID().toString();
        return generatedString;
    }
    
}
