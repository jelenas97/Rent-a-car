package com.rentCar.service.impl;

import com.rentCar.dto.UserDTO;
import com.rentCar.enumerations.AccountStatus;
import com.rentCar.model.User;
import com.rentCar.repository.UserRepository;
import com.rentCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        this.userRepository.findAllUsers();
        List<UserDTO> users = new ArrayList<>();
        for(User u : this.userRepository.findAllUsers()){
            users.add(new UserDTO(u));
        }
        return users;
    }

    @Override
    public void changeStatus(UserDTO userDTO) {
        User user = this.userRepository.findByEmail(userDTO.getEmail());
        user.setStatus(AccountStatus.valueOf(userDTO.getStatus()));
        this.userRepository.save(user);

    }


}