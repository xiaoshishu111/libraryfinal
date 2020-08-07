package com.xss.libraryfinal.service;

import com.xss.libraryfinal.domain.Book;
import com.xss.libraryfinal.global.PageBean;
import com.xss.libraryfinal.vo.BookManageView;
import com.xss.libraryfinal.vo.BookView;

public interface BookService {
    /**
     * 返回一个分页数据
     *
     * @param bookManageView
     * @return
     */
    PageBean<Book> pageBean(BookManageView bookManageView);

    /**
     * 插入一条数据
     *
     * @param book
     */
    void insert(Book book);

    /**
     * 返回用户页面的分页数据
     */
    PageBean<Book> UserPageBean(BookView bookView);
}
