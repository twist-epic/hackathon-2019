package com.tgt.epic.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tgt.epic.domain.Purchase;
import com.tgt.epic.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRecordMapper implements RowMapper<Purchase> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Purchase mapRow(ResultSet rs, int rowNum)  {
        Purchase purchase = new Purchase();
        try {
            purchase.setEmail(rs.getString("email"));
            purchase.setTitle(rs.getString("title"));
            purchase.setTcin(rs.getInt("tcin"));
            purchase.setBrand(rs.getString("brand"));
            purchase.setPrice(rs.getDouble("price"));
            purchase.setQuantity(rs.getInt("quantity"));

        } catch (SQLException e) {
            System.out.println("Error while mapping user data:" + e);
        }
        return purchase;
    }
}
