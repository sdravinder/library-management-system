package com.example.librarymanagementsystem.service.IMPL;

import com.example.librarymanagementsystem.dto.BorrowDTO;
import com.example.librarymanagementsystem.dto.BorrowSaveDTO;
import com.example.librarymanagementsystem.dto.BorrowUpdateDTO;
import com.example.librarymanagementsystem.entity.Borrow;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.BorrowRepository;
import com.example.librarymanagementsystem.repository.UserRepository;
import com.example.librarymanagementsystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public String addBorrow(BorrowSaveDTO borrowSaveDTO) {
        Borrow borrow = new Borrow(
                bookRepository.getById(borrowSaveDTO.getBook_id()),
                userRepository.getById(borrowSaveDTO.getUser_id()),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()
        );
        borrowRepository.save(borrow);
        return null;
    }

    @Override
    public List<BorrowDTO> getAllBorrow() {
        List<Borrow> getBorrow = borrowRepository.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();
        for (Borrow borrow : getBorrow) {
            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getId(),
                    borrow.getBook(),
                    borrow.getUser(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDTOList.add(borrowDTO);
        }
        return borrowDTOList;
    }

    @Override
    public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {
        try {
            if (borrowRepository.existsById(borrowUpdateDTO.getId())) {
                Borrow borrow = borrowRepository.getById(borrowUpdateDTO.getId());
                borrow.setBook(bookRepository.getById(borrowUpdateDTO.getBookId()));
                borrow.setUser(userRepository.getById(borrowUpdateDTO.getUserId()));
                borrow.setBorrowDate(borrowUpdateDTO.getBorrowDate());
                borrow.setReturnDate(borrowUpdateDTO.getReturnDate());
                borrowRepository.save(borrow);
                return "Borrow updated successfully.";
            } else {
                System.out.println("Borrow ID Not Found");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}