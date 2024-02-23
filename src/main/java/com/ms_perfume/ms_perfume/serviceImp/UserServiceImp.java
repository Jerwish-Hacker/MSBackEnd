package com.ms_perfume.ms_perfume.serviceImp;

import com.ms_perfume.ms_perfume.dto.LoginResponse;
import com.ms_perfume.ms_perfume.entity.Users;
import com.ms_perfume.ms_perfume.repo.UserRepository;
import com.ms_perfume.ms_perfume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp  implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }


    @Override
    public  LoginResponse userLogin(Users user){
        List<Users> userList=userRepository.findAll();
        LoginResponse loginResponse=new LoginResponse();
        for (Users users : userList) {
            if (user.getUserName().equals(users.getUserName())){
                if (user.getPassword().equals(users.getPassword())){

                    loginResponse.setMessage("Success");
                    return loginResponse;
                }
                else {
                    loginResponse.setMessage("Wrong Password");
                    return loginResponse;

                }
            }
        }
        loginResponse.setMessage("No User Found");
        return loginResponse;
    }

    @Override
    public Users updateUser(Long userId) {
        return null;
    }

    @Override
    public Users deleteUser(Long userId) {
        return null;
    }

    @Override
    public Users getUserById(Long userId) {
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        return null;
    }


}
