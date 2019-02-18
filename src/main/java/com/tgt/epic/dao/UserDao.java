package com.tgt.epic.dao;


import com.tgt.epic.domain.User;
import com.tgt.epic.mapper.UserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getAllUsers(){
        String selectQuery = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(selectQuery, new UserRecordMapper());
    }

    public User getOneUser(String email){
        String selectQuery = "SELECT * FROM users WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, parameterSource, new UserRecordMapper());
    }

    public void addUser(User user){
        String insertQuery = "INSERT INTO users(first_name, last_name, email, password, address) " +
                "VALUES(:first_name, :last_name, :email, :password, :address)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("first_name", user.getFirstName());
        parameterSource.addValue("last_name", user.getLastName());
        parameterSource.addValue("email", user.getEmail());
        parameterSource.addValue("password", user.getPassword());
        parameterSource.addValue("address", user.getAddress());

        namedParameterJdbcTemplate.update(insertQuery, parameterSource);
    }

    public void updateUser(User user, String oldEmail){
        String updateQuery = "UPDATE users \n" +
                "SET ADDRESS = :address, first_name = :first_name, last_name = :last_name, password = :password, email = :email\n" +
                "WHERE email = :old_email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("address", user.getAddress());
        parameterSource.addValue("email", user.getEmail());
        parameterSource.addValue("first_name", user.getFirstName());
        parameterSource.addValue("last_name", user.getLastName());
        parameterSource.addValue("password", user.getPassword());
        parameterSource.addValue("old_email", oldEmail);
        namedParameterJdbcTemplate.update(updateQuery, parameterSource);
    }

}
