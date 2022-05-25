package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.User;
import com.example.t2009m1java.util.ConnectionHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {
    private MySqlAccountModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlAccountModel();
    }

    @Test
    void save() {
        Account account = new Account("Cuong", "cuong@gmail.com", "123", "Tran Viet Cuong", "0123456789", "05/08/2002");
        assertEquals(true, model.save(account));
    }

    @Test
    void update() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set username = ?, email = ?, password = ?, fullName = ?, phone = ?, birthday = ?, status = ? where id = ?");
            preparedStatement.setString(1, "Tuan");
            preparedStatement.setString(2, "tuan@gmail.com");
            preparedStatement.setString(3, "12345678");
            preparedStatement.setString(4, "Nguyen Hoang Tuan");
            preparedStatement.setString(5, "01234567890");
            preparedStatement.setString(6, "10/10/2000");
            preparedStatement.setInt(7, 2);
            preparedStatement.setInt(8, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void delete() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set status = ? where id = ?");
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where status = ?");
            preparedStatement.setInt(1,1);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, email, password, fullName, phone, birthday, status);
                accounts.add(account);
                System.out.println(account.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findById() {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where status = ? and id = ?");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,1);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, email, password, fullName, phone, birthday, status);
                System.out.println(account.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}