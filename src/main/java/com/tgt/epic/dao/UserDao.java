package com.tgt.epic.dao;


import com.tgt.epic.domain.Purchase;
import com.tgt.epic.domain.User;
import com.tgt.epic.mapper.PurchaseRecordMapper;
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

    public User getOneUser(String email){
        String selectQuery = "SELECT * FROM users WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, parameterSource,new UserRecordMapper());
    }

    public void addUser(User user){
        String insertQuery = "INSERT INTO users(first_name, last_name, email, password, house_number, street_name, city, state, zip_code) " +
                "VALUES(:first_name, :last_name, :email, :password, :house_number, :street_name, :city, :state, :zip_code)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("first_name", user.getFirstName());
        parameterSource.addValue("last_name", user.getLastName());
        parameterSource.addValue("email", user.getEmail());
        parameterSource.addValue("password", user.getPassword());
        parameterSource.addValue("house_number", user.getHouseNumber());
        parameterSource.addValue("street_name", user.getStreetName());
        parameterSource.addValue("city", user.getCity());
        parameterSource.addValue("state", user.getState());
        parameterSource.addValue("zip_code", user.getZipCode());



        namedParameterJdbcTemplate.update(insertQuery, parameterSource);
    }

    public List<Purchase> getPurchases(String email){
        String selectQuery = "SELECT * FROM purchases WHERE email = :email";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email);
        return namedParameterJdbcTemplate.query(selectQuery, parameterSource,new PurchaseRecordMapper());
    }


}
