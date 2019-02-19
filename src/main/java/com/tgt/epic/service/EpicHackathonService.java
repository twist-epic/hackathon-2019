package com.tgt.epic.service;

import com.tgt.epic.client.RestClient;
import com.tgt.epic.dao.UserDao;
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

        List<User> myUsers= userDao.getAllUsers();
        for(User currentUser : myUsers){
            hidecaladress(currentUser);
        }
        return myUsers;
    }

    public User getUserAddress(String email){
        User user=userDao.getUserAddress(email);
        hidecaladress(user);
        return user;
    }

    public void hidecaladress(User currentUser){
        if(currentUser.getState().equals("CA")) {
            currentUser.setCity(null);
            currentUser.setZipCode(null);
            currentUser.setStreetAddress(null);
        }
    }
}
