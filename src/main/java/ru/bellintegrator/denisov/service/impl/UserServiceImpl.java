package ru.bellintegrator.denisov.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.dao.ReferenceDAO;
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.model.CitizenshipType;
import ru.bellintegrator.denisov.model.Document;
import ru.bellintegrator.denisov.model.DocumentType;
import ru.bellintegrator.denisov.model.Office;
import ru.bellintegrator.denisov.model.User;
import ru.bellintegrator.denisov.service.UserService;
import ru.bellintegrator.denisov.view.UserFilterView;
import ru.bellintegrator.denisov.view.UserView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
 
    private final UserDAO userDAO;
    private final OfficeDAO officeDAO;
    private final ReferenceDAO refDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, OfficeDAO officeDAO, ReferenceDAO refDAO) {
        this.userDAO = userDAO;
        this.officeDAO = officeDAO;
        this.refDAO = refDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> users(UserFilterView filterView) {
        List<UserView> result = new ArrayList<>();
        List<User> users = userDAO.all(filterView);
        
        for(User user : users) {
            UserView view = user.toConvertFilterUserDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView user(String id) {
        Long userId = Long.parseLong(id, 10);
        User user = userDAO.loadById(userId);
        
        UserView view = user.toConvertUserDTO();
        
        log.info(view.toString());
        
        return view;
    }

    @Override
    @Transactional
    public void update(UserView view) {
        Long updatingUserId = Long.parseLong(view.id, 10);
        User user = userDAO.loadById(updatingUserId);
        DocumentType docType = refDAO.loadDocTypeByName(view.docName);
        
        user = view.toConvertUserEntity(user, docType);
        
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Long userId = Long.parseLong(id, 10);
        userDAO.delete(userId);
    }

    @Override
    @Transactional
    public void save(UserView view) {
        DocumentType docType = refDAO.loadDocTypeByName(view.docName);
        Long officeId = Long.parseLong(view.officeId);
        Office userOffice = officeDAO.loadById(officeId);
        
        User user = view.toConvertUserEntity(userOffice, docType);
        
        userDAO.save(user);
    }
    
}
