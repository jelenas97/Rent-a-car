package com.rentCar.service;

import com.rentCar.dto.UserDTO;
import com.rentCar.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

    void changeStatus(UserDTO user);

    User findOne(String email);

    User findByUsername(String username);

    User save(User user);

    User findById(Long id);

}
