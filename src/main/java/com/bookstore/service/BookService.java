package com.bookstore.service;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    BookResponseDto saveBook(BookRequestDto dto);
    List<BookResponseDto> getAllBooks();
    List<BookResponseDto>searchBooks(String title); //Search API
    BookResponseDto getBookById(Long id);

    BookResponseDto updateBook(Long id,BookRequestDto dto);

    void deleteBook(Long id);
    Page<BookResponseDto> getAllBooks(Pageable pageable); //Pagination
}
