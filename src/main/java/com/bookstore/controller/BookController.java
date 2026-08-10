package com.bookstore.controller;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookResponseDto saveBook(@Valid @RequestBody BookRequestDto dto) {
        return bookService.saveBook(dto);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks()  //user la all books pahije astil tevha
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/page") //
    public Page<BookResponseDto>getAllBooksWithPagination(@RequestParam(defaultValue = "0")int page,  //for pagination
                                                          @RequestParam(defaultValue = "3")int size)
    {
        Pageable pageable= PageRequest.of(page,size);
        return bookService.getAllBooks(pageable);
    }


    @GetMapping("/{id}")            //id nusar specific 1 book get karayla
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")   //for pagination
    public BookResponseDto updateBook(@PathVariable Long id,@Valid @RequestBody BookRequestDto dto)  //particular 1 ch book update karaych assel trr
    {
        return bookService.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")  //search API
    public List<BookResponseDto> searchbooks(@RequestParam String title) {
        return bookService.searchBooks(title);
    }

}
