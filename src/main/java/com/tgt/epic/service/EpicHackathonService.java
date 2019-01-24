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
        return userDao.getAllUsers();
    }

    public User getOneUser(String email){
        return userDao.getOneUser(email);
    }

    public void deleteOneUser(String email) {
        userDao.deleteOneUser(email);
    }

}