package com.xss.libraryfinal.service;

import com.xss.libraryfinal.domain.BookType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookTypeService {

    /**
     * 返回某个分类的所有子类
     *
     * @param bookTypeId
     * @return
     */
    List<BookType> getChildren(String bookTypeId);

    /**
     * 返回某个分类及其所有子类分类
     *
     * @return
     */
    BookType getRoot();

    /**
     * 删除某个分类
     *
     * @param bookTypeId
     */
    void remove(String bookTypeId);

    /**
     * 批量插入分类数据
     *
     * @param list
     */
    void banchInsert(List<BookType> list);
}
