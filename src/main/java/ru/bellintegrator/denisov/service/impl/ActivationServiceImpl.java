package ru.bellintegrator.denisov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.denisov.dao.AccountDAO;
import ru.bellintegrator.denisov.service.ActivationService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ActivationServiceImpl implements ActivationService {
    
    private final AccountDAO dao;

    @Autowired
    public ActivationServiceImpl(AccountDAO dao) {
        this.dao = dao;
    }
    
    @Override
    public void activation(String code) {
// Общая логика активации аккаунта:
//        4. Контроллер activation берёт хэш от значения code и ищет по ней запись. 
//            Если находит, делает активным соответствующего пользователя * 
//            Для хэша используется SHA-256. Получение его вынесено в отдельный сервис.
//            + хэш от пароля в базе надо хранить закодированным в base64, типа, требования безопасности))
    }
    
}
