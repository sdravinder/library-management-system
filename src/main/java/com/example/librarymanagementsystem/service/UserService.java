package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.UserDTO;
import com.example.librarymanagementsystem.dto.UserSaveDTO;
import com.example.librarymanagementsystem.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deleteUser(int id);
}
