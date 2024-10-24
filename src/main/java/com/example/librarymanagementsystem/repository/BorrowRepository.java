package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}
