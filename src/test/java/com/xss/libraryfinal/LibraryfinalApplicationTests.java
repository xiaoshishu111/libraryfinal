package com.xss.libraryfinal;


import com.xss.libraryfinal.domain.BookType;
import com.xss.libraryfinal.mapper.AdminMapper;
import com.xss.libraryfinal.mapper.BookMapper;
import com.xss.libraryfinal.mapper.BookTypeMapper;
import com.xss.libraryfinal.service.AdminService;
import com.xss.libraryfinal.service.BookService;
import com.xss.libraryfinal.service.BookTypeService;
import com.xss.libraryfinal.vo.BookManageView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryfinalApplicationTests {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private BookManageView bookManageView;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeMapper bookTypeMapper;
    @Autowired
    private BookTypeService bookTypeService;

    @Test
    void contextLoads() {
        System.out.println(bookTypeMapper.selectByPrimaryKey("8888"));
    }

}
