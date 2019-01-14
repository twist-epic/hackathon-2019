package com.tgt.epic.dao;


import com.tgt.epic.domain.User;
import org.h2.jdbc.JdbcSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tgt.epic.mapper.UserRecordMapper;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<User> getAllUsers(){
        String selectQuery = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(selectQuery, new UserRecordMapper());
    }

    public void addUser(User user){
        String insertQuery = "INSERT INTO users(first_name, last_name, email, password) " +
                "VALUES(:first_name, :last_name, :email, :password)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("first_name", user.getFirstName());
        parameterSource.addValue("last_name", user.getLastName());
        parameterSource.addValue("email", user.getEmail());
        parameterSource.addValue("password", user.getPassword());

        namedParameterJdbcTemplate.update(insertQuery, parameterSource);
    }

}
