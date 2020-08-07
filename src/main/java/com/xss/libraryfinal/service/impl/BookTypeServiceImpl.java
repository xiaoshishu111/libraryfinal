package com.xss.libraryfinal.service.impl;

import com.xss.libraryfinal.constants.Constants;
import com.xss.libraryfinal.domain.BookType;
import com.xss.libraryfinal.mapper.BookTypeMapper;
import com.xss.libraryfinal.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> getChildren(String bookTypeId) {
        return bookTypeMapper.getChildren(bookTypeId);
    }

    @Override
    public BookType getRoot() {
        return bookTypeMapper.selectByPrimaryKey(Constants.ROOTID);
    }

    @Override
    public void remove(String bookTypeId) {
        bookTypeMapper.deleteByPrimaryKey(bookTypeId);
    }

    @Override
    public void banchInsert(List<BookType> list) {
        bookTypeMapper.banchInsert(list);
    }
}
