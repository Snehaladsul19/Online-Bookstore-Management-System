package com.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookRequestDto {
     @NotBlank(message = "title is required")
    private String title;
     @NotBlank(message ="author name is required")
    private String author;
     @NotNull(message = "price is required")
    private Double price;
     @NotNull(message = "quantity is required")
     @PositiveOrZero(message="Quantity cannot be negative")
    private Integer quantity;
}
