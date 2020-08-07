package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.Book;
import com.xss.libraryfinal.vo.BookManageView;
import com.xss.libraryfinal.vo.BookView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(String bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String bookid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    /**
     * 返回分页的书本数据
     * @param bookManageView
     * @return
     */
    List<Book> pageBean(BookManageView bookManageView);

    /**
     * 返回分页总个数
     * @param bookManageView
     * @return
     */
    int getTotalCount(BookManageView bookManageView);

    /**
     * 查询所有状态为推荐的个数
     */

    int getRecommand(int bookstatus);

    /**
     * 查询所有状态为推荐的书本
     */

    List<Book> getRecommandBooks();

    /**
     * 获取被借此书前12的书本
     */

    List<Book> getList(int rank);

    /**
     * 查找所有为某个分类的书本
     */
    List<Book> getTypeBooks(BookView bookView);

    /**
     * 查找所有某个分类的个数
     */
    int getCountTypeBooks(BookView bookView);
}