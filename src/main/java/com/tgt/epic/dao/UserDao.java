package com.tgt.epic.dao;


import com.tgt.epic.domain.User;
import com.tgt.epic.mapper.UserMapperAddress;
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

    public User getUserAddress(String email) {
        String selectQuery = "SELECT user.street_address, user.city, user.state, user.zip_code FROM users As user Where user.email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, parameterSource, new UserMapperAddress());
    }

    public void addUser(User user){
        String insertQuery = "INSERT INTO users(first_name, last_name, email, password, street_address, city, state, zip_code) " +
                "VALUES(:first_name, :last_name, :email, :password, :street_address, :city, :state, :zip_code)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("first_name", user.getFirstName());
        parameterSource.addValue("last_name", user.getLastName());
        parameterSource.addValue("email", user.getEmail());
        parameterSource.addValue("password", user.getPassword());
        parameterSource.addValue("street_address", user.getStreetAddress());
        parameterSource.addValue("city", user.getCity());
        parameterSource.addValue("state", user.getState());
        parameterSource.addValue("zip_code", user.getZipCode());

        namedParameterJdbcTemplate.update(insertQuery, parameterSource);
    }

}
