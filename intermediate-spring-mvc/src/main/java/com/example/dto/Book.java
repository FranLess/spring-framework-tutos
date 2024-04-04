package com.example.dto;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Setter
    @Getter
    private String title = "Default title";

    @Setter
    @Getter
    private String description = "Default description";

    @Setter
    @Getter
    private String author = "Default author";
}
