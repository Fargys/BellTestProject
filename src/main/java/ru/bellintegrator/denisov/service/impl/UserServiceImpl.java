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
import ru.bellintegrator.denisov.exception.UserSeviceException;
import ru.bellintegrator.denisov.model.Citizenship;
import ru.bellintegrator.denisov.model.Document;
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
    public List<UserView> getAllUsersByCriteria(UserFilterView filterView) {
        List<UserView> result = new ArrayList<>();
        List<User> users = userDAO.getAllUsersByCriteria(filterView);
        
        for(User user : users) {
            UserView view = user.toConvertFilterUserDTO();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView getUserById(String id) {
        Long userId = Long.parseLong(id, 10);
        User user = userDAO.getUserById(userId);
        if(user == null) throw new UserSeviceException("No user has id = " + id);
        
        UserView view = user.toConvertUserDTO();
        
        log.info(view.toString());
        
        return view;
    }

    @Override
    @Transactional
    public void updateUser(UserView view) {
        Long updatingUserId = Long.parseLong(view.id, 10);
        User user = userDAO.getUserById(updatingUserId);
        if(user == null) throw new UserSeviceException("No user has id = " + updatingUserId);
        
        Document document = refDAO.getDocumentByName(view.docName);
        Citizenship citizenthip = refDAO.getCitizenshipByName(view.citizenshipName);
        
        user = view.toConvertUserEntity(user, document, citizenthip);
        
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        Long userId = Long.parseLong(id, 10);
        userDAO.deleteUser(userId);
    }

    @Override
    @Transactional
    public void saveUser(UserView view) {
        Long officeId = Long.parseLong(view.officeId);
        Office office = officeDAO.getOfficeById(officeId);
        if(office == null) throw new UserSeviceException("No office has id = " + officeId);
        
        Document document = refDAO.getDocumentByName(view.docName);
        Citizenship citizenthip = refDAO.getCitizenshipByName(view.citizenshipName);
        
        User user = view.toConvertUserEntity(office, document, citizenthip);
        
        userDAO.saveUser(user);
    }
    
}
