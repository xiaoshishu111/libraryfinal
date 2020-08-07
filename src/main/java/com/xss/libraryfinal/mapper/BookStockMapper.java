package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.BookStock;

public interface BookStockMapper {
    int deleteByPrimaryKey(String bookstockid);

    int insert(BookStock record);

    int insertSelective(BookStock record);

    BookStock selectByPrimaryKey(String bookstockid);

    int updateByPrimaryKeySelective(BookStock record);

    int updateByPrimaryKey(BookStock record);
}