package com.tgt.epic.service;

import com.tgt.epic.client.RestClient;
import com.tgt.epic.dao.UserDao;
import com.tgt.epic.domain.Purchase;
import com.tgt.epic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EpicHackathonService {

    @Autowired
    private RestClient restClient;

    @Autowired
    private UserDao userDao;

    public boolean addUser(User user){
        userDao.addUser(user);
        return true;
    }

    public List<User> getAllUsers(){
        List<User> unmodifiedListOfUsers =  userDao.getAllUsers();
        for (User currentUser:unmodifiedListOfUsers){
            removeAddress(currentUser);

        }
        return unmodifiedListOfUsers;
    }

    private void removeAddress(User currentUser) {
        if (currentUser.getZipCode()==90210){
            currentUser.setHouseNumber(-1);
            currentUser.setStreetName("unknown");
            currentUser.setCity("unknown");
            currentUser.setState("unknown");
            currentUser.setZipCode(-1);
        }
    }

    public User getOneUser(String email){

        User user = userDao.getOneUser(email);
        removeAddress(user);
        return user;
}
public List<Purchase> getPurchases(String email) {
        List<Purchase> purchases = userDao.getPurchases(email);
        return purchases;
}

}
