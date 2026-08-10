package com.bookstore.service.impl;

import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

import com.bookstore.dto.BookRequestDto;
import com.bookstore.dto.BookResponseDto;
import com.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponseDto saveBook(BookRequestDto dto) {
        Book book=Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
        Book savedBook=bookRepository.save(book);  //ya class mdheun bookrepo call hoto

        return new BookResponseDto(
                savedBook.getId(),
                savedBook.getTitle(),
                savedBook.getAuthor(),
                savedBook.getPrice(),
                savedBook.getQuantity()
        );
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book>books =bookRepository.findAll();

        return books.stream()
                .map(book->new BookResponseDto(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getQuantity()
                        ))

                .toList();
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(() ->
                      new ResourceNotFoundException("Book not found with id : " + id)
                );

        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                    book.getAuthor(),
                book.getPrice(),
                book.getQuantity()
        );
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Bok not found by ID " + id)
                );

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setQuantity(dto.getQuantity());

        Book updateBook= bookRepository.save(book);

        return new BookResponseDto(
                updateBook.getId(),
                updateBook.getTitle(),
                updateBook.getAuthor(),
                updateBook.getPrice(),
                updateBook.getQuantity()
        );
    }

    @Override
    public void deleteBook(Long id) {
        Book book =bookRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Book not found by ID" + id)
                );
        bookRepository.delete(book);
    }

    @Override
    public List<BookResponseDto>searchBooks(String title) {   //Serach API
        List<Book> books =
                bookRepository.findByTitleContainingIgnoreCase(title);

        return books.stream()
                .map(book -> new BookResponseDto(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getQuantity()
                ))
                .toList();
    }

        @Override
                public Page<BookResponseDto> getAllBooks(Pageable pageable){

            Page<Book> books = bookRepository.findAll(pageable);

            return books.map(book ->new BookResponseDto(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getQuantity()
            ));
        }
}
