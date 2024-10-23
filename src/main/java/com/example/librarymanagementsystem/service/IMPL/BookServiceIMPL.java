package com.example.librarymanagementsystem.service.IMPL;

import com.example.librarymanagementsystem.dto.BookDTO;
import com.example.librarymanagementsystem.dto.BookSaveDTO;
import com.example.librarymanagementsystem.dto.BookUpdateDTO;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.PublisherRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL  implements BookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getTitle(),
                authorRepository.getById(bookSaveDTO.getAuthor_id()),
                publisherRepository.getById(bookSaveDTO.getPublisher_id())
        );
        bookRepository.save(book);
        return book.getTitle();
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> getBooks = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : getBooks)
        {
            BookDTO bookDTO = new BookDTO(
                    book.getBookid(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher()
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if(bookRepository.existsById(bookUpdateDTO.getBookid())) {
            Book book = bookRepository.getById(bookUpdateDTO.getBookid());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuthor(authorRepository.getById(bookUpdateDTO.getAuthor_id()));
            book.setPublisher(publisherRepository.getById(bookUpdateDTO.getPublisher_id()));
            bookRepository.save(book);
            return book.getTitle();
        }
        else
        {
            System.out.println("Book ID Not Found");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if(bookRepository.existsById(id))
        {
            bookRepository.deleteById(id);
        }
        else
        {
            System.out.println("Book ID Not Found");
        }
        return null;
    }

}
