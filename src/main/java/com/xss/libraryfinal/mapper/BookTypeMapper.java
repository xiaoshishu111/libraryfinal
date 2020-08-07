package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeMapper {
    int deleteByPrimaryKey(String booktypeid);

    int insert(BookType record);

    int insertSelective(BookType record);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);

    /**
     * 用户查询某个分类下的所有子类
     * @param bookTypePid
     * @return
     */
    List<BookType> getChildren(String bookTypePid);

    /**
     * 用于查询某个分类及其分类下的所有子类
     * @param booktypeid
     * @return
     */
    BookType selectByPrimaryKey(String booktypeid);

    /**
     * 批量插入分类数据
     * @param list
     */
    void banchInsert(List<BookType> list);
}