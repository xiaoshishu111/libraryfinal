package com.xss.libraryfinal.service.impl;

import com.xss.libraryfinal.domain.Book;
import com.xss.libraryfinal.global.PageBean;
import com.xss.libraryfinal.mapper.BookMapper;
import com.xss.libraryfinal.service.BookService;
import com.xss.libraryfinal.vo.BookManageView;
import com.xss.libraryfinal.vo.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PageBean<Book> pageBean;

    @Override
    public PageBean<Book> pageBean(BookManageView bookManageView) {
        pageBean.setCurrentCount(bookManageView.getCurrentCount());
        pageBean.setCurrentPage(bookManageView.getCurrentPage());
        pageBean.setTotalCount(bookMapper.getTotalCount(bookManageView));
        pageBean.setBeans(bookMapper.pageBean(bookManageView));
        pageBean.setTotalPage(0);
        return pageBean;
    }



    @Override
    public void insert(Book book){
        bookMapper.insert(book);
    }

    @Override
    public PageBean<Book> UserPageBean(BookView bookView) {
        pageBean.setCurrentCount(bookView.getCurrentCount());
        pageBean.setCurrentPage(bookView.getCurrentPage());
        pageBean.setTotalCount(bookMapper.getCountTypeBooks(bookView));
        pageBean.setBeans(bookMapper.getTypeBooks(bookView));
        pageBean.setTotalPage(0);
        return pageBean;
    }

}
