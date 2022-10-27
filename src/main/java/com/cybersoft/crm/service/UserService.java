package com.cybersoft.crm.service;

import com.cybersoft.crm.model.UsersModel;
import com.cybersoft.crm.repository.UsersRepository;

import java.util.List;

public class UserService {

    private final UsersRepository usersRepository = new UsersRepository();

    public List<UsersModel> getAllUsers() {

        return usersRepository.getUsersList();
    }

    public List<UsersModel> getUserById(int id) {

        List<UsersModel> list = usersRepository.getUserId(id);

        return list;
    }

    public int addUser(String email,String password, String avatar, String fullName, int RoleId){

        UsersModel usersModel = new UsersModel();
        usersModel.setEmail(email);
        usersModel.setPassword(password);
        usersModel.setAvatar(avatar);
        usersModel.setFullName(fullName);
        usersModel.setRoleId(RoleId);

        return usersRepository.insert(usersModel);
    }

    public boolean updateUser(String email,String password, String avatar, String fullName, int roleId, int id){

        UsersModel usersModel = new UsersModel();
        usersModel.setEmail(email);
        usersModel.setPassword(password);
        usersModel.setAvatar(avatar);
        usersModel.setFullName(fullName);
        usersModel.setRoleId(roleId);
        usersModel.setId(id);

        return usersRepository.update(usersModel) > 0;
    }

    public boolean deleteUserById(int id){
        int result = usersRepository.deleteUserById(id);
        return result > 0;
    }
}

