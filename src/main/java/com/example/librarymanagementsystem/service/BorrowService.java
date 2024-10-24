package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.BorrowDTO;
import com.example.librarymanagementsystem.dto.BorrowSaveDTO;
import com.example.librarymanagementsystem.dto.BorrowUpdateDTO;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAllBorrow();

    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);
}
