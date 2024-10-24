package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dto.*;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO)
    {
        String bookTitle = userService.addUser(userSaveDTO);
        return  "Added Successfully";
    }

    @GetMapping(path = "/getAllUser")
    public List<UserDTO> getAllUser()
    {
        List<UserDTO> allUser = userService.getAllUser();
        return allUser;
    }

    @PutMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO)
    {
        String userName = userService.updateUser(userUpdateDTO);
        return  userName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id")int id)
    {
        String Username = userService.deleteUser(id);
        return  "User Deleted Successfully";
    }

}
