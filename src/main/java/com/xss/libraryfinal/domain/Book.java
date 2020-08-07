package com.xss.libraryfinal.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Book {
    private String bookid;

    private String bookname;

    private String bookicon;

    private String bookauthor;

    private String booktypeid;

    private BigDecimal bookprice;

    private String bookpublisher;

    private String bookabstract;

    private String bookstockid;

    private String booktype;

    private String borrowedtimes;

    private int bookstatus;
}