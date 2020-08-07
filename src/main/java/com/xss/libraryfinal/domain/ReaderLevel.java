package com.xss.libraryfinal.domain;

import lombok.Data;

@Data
public class ReaderLevel {
    private String readerlevelid;

    private Integer maxboorrownums;

    private Integer maxborrowdays;

}