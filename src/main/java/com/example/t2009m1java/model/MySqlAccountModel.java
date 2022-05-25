package com.example.t2009m1java.model;

import com.example.t2009m1java.entity.Account;
import com.example.t2009m1java.entity.User;
import com.example.t2009m1java.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    @Override
    public boolean save(Account account) {
            Connection connection = ConnectionHelper.getConnection();
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into accounts (username, email, password, fullName, phone, birthday) values (?,?,?,?,?,?)");
                preparedStatement.setString(1, account.getUsername());
                preparedStatement.setString(2, account.getEmail());
                preparedStatement.setString(3, account.getPassword());
                preparedStatement.setString(4, account.getFullName());
                preparedStatement.setString(5, account.getPhone());
                preparedStatement.setString(6, account.getBirthday());
    //            preparedStatement.setInt(3, account.getStatus());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }

    @Override
    public boolean update(int id, Account updateAccount) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set username = ?, email = ?, password = ?, fullName = ?, phone = ?, birthday = ?, status = ? where id = ?");
            preparedStatement.setString(1, updateAccount.getUsername());
            preparedStatement.setString(2, updateAccount.getEmail());
            preparedStatement.setString(3, updateAccount.getPassword());
            preparedStatement.setString(4, updateAccount.getFullName());
            preparedStatement.setString(5, updateAccount.getPhone());
            preparedStatement.setString(6, updateAccount.getBirthday());
            preparedStatement.setInt(7, updateAccount.getStatus());
            preparedStatement.setInt(8, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update accounts set status = ? where id = ?");
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account findById(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from accounts where status = ? and id = ?");
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, email, password, fullName, phone, birthday, status);
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
