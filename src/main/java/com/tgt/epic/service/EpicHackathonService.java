package com.tgt.epic.service;

import com.tgt.epic.client.RestClient;
import com.tgt.epic.dao.UserDao;
import com.tgt.epic.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean updateUser(User user, String oldEmail){
        userDao.updateUser(user, oldEmail);
        return true;
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getOneUser(String email){
        User user = userDao.getOneUser(email);
        user.setPassword("");
        return user;
    }
}
