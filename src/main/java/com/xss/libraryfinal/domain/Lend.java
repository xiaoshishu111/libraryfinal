package com.xss.libraryfinal.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Lend {
    private String lendid;

    private String readerid;

    private String readername;

    private String bookid;

    private String bookname;

    private Date begintime;

    private Date endtime;



}