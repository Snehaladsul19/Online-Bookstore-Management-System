package com.bookstore.controller;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //create Rest API and handle HTTP request
@RequestMapping("/books")  //map a http request to controller or controller method. define common URL
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookResponseDto saveBook(@Valid @RequestBody BookRequestDto dto)  //book add or new data create karnya sathi
    {
        return bookService.saveBook(dto);
    }

    @GetMapping
    public List<BookResponseDto>getAllBooks()  //used to retrieve book all books or specific book
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/page") //
    public Page<BookResponseDto>getAllBooksWithPagination(@RequestParam(defaultValue = "0")int page,  //for pagination and sorting
                                                          @RequestParam(defaultValue = "3")int size,
                                                         @RequestParam(defaultValue = "price")String sortBy,
                                                         @RequestParam(defaultValue = "asc") String direction)

       {
           Sort sort;

           if(direction.equalsIgnoreCase("desc"))  //for desc
           {
               sort=Sort.by(sortBy).descending();
           }
           else
           {
             sort=Sort.by(sortBy).ascending();
           }
           Pageable pageable=PageRequest.of(page,size,sort);
           return bookService.getAllBooks(pageable);
       }

        @GetMapping("/{id}")            //id nusar specific 1 book get karayla
        public BookResponseDto getBookById (@PathVariable Long id){
        return bookService.getBookById(id);
    }


    @PutMapping("/{id}")   //for pagination
    public BookResponseDto updateBook(@PathVariable Long id,@Valid @RequestBody BookRequestDto dto)  //particular 1 ch book update karaych assel trr
    {
        return bookService.updateBook(id, dto);
    }

    @DeleteMapping("/delete-all")   //if we want to delete all book
    public void deleteAllBooks() {
        bookService.deleteAllBooks();  //for delete all books
    }

    @DeleteMapping("/{id}")    //specific id nusar book delete karayla
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")  //search API  search book by name
    public List<BookResponseDto> searchbooks(@RequestParam String title) {
        return bookService.searchBooks(title);
    }



}
