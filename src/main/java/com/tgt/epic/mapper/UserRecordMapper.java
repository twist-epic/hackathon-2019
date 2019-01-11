package com.tgt.epic.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.epic.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRecordMapper implements RowMapper<User> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public User mapRow(ResultSet rs, int rowNum)  {
        User user = new User();
        try {
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
        } catch (SQLException e) {
            System.out.println("Error while mapping user data:" + e);
        }
        return user;
    }
}
