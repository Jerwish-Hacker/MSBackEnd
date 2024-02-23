package com.ms_perfume.ms_perfume.service;

import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.Users;

import java.util.List;

public interface UserService {

    LoginResponse userLogin(Users user);
    Users createUser(Users user);
    Users updateUser(Long userId);
    Users deleteUser(Long userId);
    Users getUserById(Long userId);
    List<Users> getAllUsers();
}
