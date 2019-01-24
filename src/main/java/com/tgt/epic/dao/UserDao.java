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

    public User getOneUser(String searchEmail) {
        String selectQuery = "SELECT * FROM users WHERE email = " + "'" + searchEmail + "'";
        return namedParameterJdbcTemplate.query(selectQuery, new UserRecordMapper()).get(0);
    }

    public void deleteOneUser(String searchEmail){
        String selectQuery = "DELETE FROM users WHERE email = :searchEmail";
        namedParameterJdbcTemplate.update(selectQuery,
                new MapSqlParameterSource("searchEmail", searchEmail));
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

}

