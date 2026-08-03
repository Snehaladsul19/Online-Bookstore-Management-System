package com.bookstore.service;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;

import java.util.List;

public interface BookService {

    BookResponseDto saveBook(BookRequestDto dto);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto updateBook(Long id,BookRequestDto dto);

    void deleteBook(Long id);

}
