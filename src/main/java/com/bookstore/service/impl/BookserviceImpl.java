package com.bookstore.service.impl;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookserviceImpl implements BookService {

    @Override
    public BookResponseDto saveBook(BookRequestDto dto) {
        return null;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return List.of();
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return null;
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
