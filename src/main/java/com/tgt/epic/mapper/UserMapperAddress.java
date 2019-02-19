package com.tgt.epic.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.epic.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperAddress implements RowMapper<User> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public User mapRow(ResultSet rs, int rowNum)  {
        User user = new User();
        try {



            user.setStreetAddress(rs.getString("street_address"));
            user.setCity(rs.getString("city"));
            user.setState(rs.getString("state"));
            user.setZipCode(rs.getInt("zip_code"));
        } catch (SQLException e) {
            System.out.println("Error while mapping user data:" + e);
        }
        return user;
    }
}
