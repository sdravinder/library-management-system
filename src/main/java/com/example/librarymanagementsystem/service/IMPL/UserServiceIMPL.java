package com.example.librarymanagementsystem.service.IMPL;

import com.example.librarymanagementsystem.dto.PublisherUpdateDTO;
import com.example.librarymanagementsystem.dto.UserDTO;
import com.example.librarymanagementsystem.dto.UserSaveDTO;
import com.example.librarymanagementsystem.dto.UserUpdateDTO;
import com.example.librarymanagementsystem.entity.Publisher;
import com.example.librarymanagementsystem.entity.User;
import com.example.librarymanagementsystem.repository.UserRepository;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        User user = new User(
                userSaveDTO.getName(),
                userSaveDTO.getEmail(),
                userSaveDTO.getAddress(),
                userSaveDTO.getPhone()
        );

        userRepository.save(user);
        return "Added Successfully";
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getAllUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : getAllUser) {
            UserDTO userDTO = new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getPhone()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepository.existsById(userUpdateDTO.getUserId())) {
            User user = userRepository.getById(userUpdateDTO.getUserId());
            user.setName(userUpdateDTO.getName());
            userRepository.save(user);
            return user.getName();
        } else {
            System.out.println("User ID Not Exist!!!!!!!!");
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            System.out.println("ID Not Found");
        }
        return null;
    }

}
