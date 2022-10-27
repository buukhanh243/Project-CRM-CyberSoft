package com.cybersoft.crm.repository;

import com.cybersoft.crm.config.MysqlConnection;
import com.cybersoft.crm.model.UsersModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    //Đối với câu lấy giá trị : Select => excuteQuery
//            insert,Update,Delete => excuteUpte
    public List<UsersModel> getUsersByEmailAndPassword(String email, String password) {
        List<UsersModel> list = new ArrayList<>();
        try {
            String query = "select * from users u where u.email = ? and u.password = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setAvatar(resultSet.getString("avatar"));
                usersModel.setFullName(resultSet.getString("fullname"));
                usersModel.setRoleId(resultSet.getInt("role_id"));

                list.add(usersModel);
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error getUsersByEmailAndPassword " + e.getMessage());
        }

        return list;
    }

    public List<UsersModel> getUserId(int id) {
        List<UsersModel> list = new ArrayList<>();

        try {
            String query = "select * from users where users.id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setAvatar(resultSet.getString("avatar"));
                usersModel.setFullName(resultSet.getString("fullname"));
                usersModel.setPassword(resultSet.getString("password"));
                usersModel.setRoleId(resultSet.getInt("role_id"));

                list.add(usersModel);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error getUsersList" + e.getMessage());
        }

        return list;

    }

    public List<UsersModel> getUsersList() {
        List<UsersModel> list = new ArrayList<>();

        try {
            String query = "select * from users";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setAvatar(resultSet.getString("avatar"));
                usersModel.setFullName(resultSet.getString("fullname"));
                usersModel.setRoleId(resultSet.getInt("role_id"));

                list.add(usersModel);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error getUsersList" + e.getMessage());
        }

        return list;

    }

    public int insert(UsersModel usersModel) {
        int result = 0;
        try {

            String query = "INSERT INTO users (email, password, avatar, fullname, role_id) VALUE (?,?,?,?,?)";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usersModel.getEmail());
            preparedStatement.setString(2, usersModel.getPassword());
            preparedStatement.setString(3, usersModel.getAvatar());
            preparedStatement.setString(4, usersModel.getFullName());
            preparedStatement.setInt(5, usersModel.getRoleId());

            result = preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error insert user " + e.getMessage());
        }
        return result;
    }

    public int update(UsersModel model) {
        int result = 0;
        try {

            String query = "UPDATE users SET email = ?, password = ?, avatar = ?, fullname = ?, role_id = ? WHERE id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, model.getEmail());
            preparedStatement.setString(2, model.getPassword());
            preparedStatement.setString(3, model.getAvatar());
            preparedStatement.setString(4, model.getFullName());
            preparedStatement.setInt(5, model.getRoleId());
            preparedStatement.setInt(6, model.getId());

            result = preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error update user " + e.getMessage());
        }
        return result;
    }

    public int deleteUserById(int id) {
        int result = 0;
        try {
            String query = "delete from users r where r.id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error deleteUserById " + e.getMessage());
        }

        return result;
    }



}
