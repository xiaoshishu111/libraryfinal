package com.xss.libraryfinal.domain;

import lombok.Data;

import java.util.List;

@Data
public class BookType {
    private String booktypeid;

    private String booktype;

    private String booklocation;

    private String booktypepid;

    private List<BookType> children;

    private String booktypeinf;


}