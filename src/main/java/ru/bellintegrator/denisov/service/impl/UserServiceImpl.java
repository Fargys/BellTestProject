package ru.bellintegrator.denisov.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.denisov.dao.OfficeDAO;
import ru.bellintegrator.denisov.dao.UserDAO;
import ru.bellintegrator.denisov.model.CitizenshipType;
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

    @Autowired
    public UserServiceImpl(UserDAO userDAO, OfficeDAO officeDAO) {
        this.userDAO = userDAO;
        this.officeDAO = officeDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> users(UserFilterView filterView) {
        List<UserView> result = new ArrayList<>();
        List<User> users = userDAO.all(filterView);
        
        for(User user : users) {
            UserView view = new UserView();
            
            view.id = String.valueOf(user.getId());
            view.firstName = user.getFirstName();
            view.secondName = user.getSecondName();
            view.middleName = user.getMiddleName();
            view.position = user.getPosition();
            
            log.info(view.toString());
            
            result.add(view);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView user(String id) {
        Long userId = Long.parseLong(id, 10);
        UserView view = new UserView();
        
        User user = userDAO.loadById(userId);
        view.id = String.valueOf(user.getId());
        view.firstName = user.getFirstName();
        view.secondName = user.getSecondName();
        view.middleName = user.getMiddleName();
        view.position = user.getPosition();
        view.phone = user.getPhone();
        view.isIdentified = user.isIdentified();
        
        Document userDoc = user.getDocument();
        view.docName = userDoc.getName();
        view.docNumber = userDoc.getNumber();
        view.docDate = userDoc.getDate();
        
        CitizenshipType userCitizenship = user.getCitizenship();
        view.citizenshipName = userCitizenship.getName();
        view.citizenshipCode = userCitizenship.getCode();
        
        log.info(view.toString());
        
        return view;
    }

    @Override
    @Transactional
    public void update(UserView view) {
        Long updatingUserId = Long.parseLong(view.id, 10);
        
        User user = userDAO.loadById(updatingUserId);
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);
        user.setIdentified(view.isIdentified);
        
        Document userDoc = user.getDocument();
        userDoc.setName(view.docName);
        userDoc.setNumber(view.docNumber);
        userDoc.setDate(view.docDate);
        
        CitizenshipType userCitizenship = user.getCitizenship();
        userCitizenship.setName(view.citizenshipName);
        userCitizenship.setCode(view.citizenshipCode);
        
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
        
        Document userDoc = new Document();
        userDoc.setName(view.docName);
        userDoc.setNumber(view.docNumber);
        userDoc.setDate(view.docDate);
        
        CitizenshipType userCitizenship = new CitizenshipType();
        userCitizenship.setName(view.citizenshipName);
        userCitizenship.setCode(view.citizenshipCode);
        
        Long officeId = Long.parseLong(view.officeId);
        Office userOffice = officeDAO.loadById(officeId);
        
        User user = new User();
        user.setFirstName(view.firstName);
        user.setSecondName(view.secondName);
        user.setMiddleName(view.middleName);
        user.setPosition(view.position);
        user.setPhone(view.phone);
        user.setIdentified(view.isIdentified);
        user.setDocument(userDoc);
        user.setCitizenship(userCitizenship);
        user.setOffice(userOffice);
        
        userDAO.save(user);
    }
}
