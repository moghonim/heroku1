package com.stackdeans.loginregister.service;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ApiKey {
    private final DataSource dataSource;

    ApiKey(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ResultSet get(String key) {

            try (Connection conn = dataSource.getConnection()) {
//                    final String sql = "SELECT * FROM auth WHERE api_key = ?";
                final String sql = "SELECT * FROM auth WHERE api_key = ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, key);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
//                                System.out.println(rs.toString());
                            // Create an authentication object to hold the credentials, principal,
                            // permissions, etc. that will be validated by the KeyAuthenticationManager
                            return rs;
                        } else {
                            return null;
                        }
                    }
                }
            } catch (SQLException e) {
                // In the event of database errors during authentication just log the error and return
                // an empty mono which will result in the request failing authentication.
                return null;
            }

    }
}
