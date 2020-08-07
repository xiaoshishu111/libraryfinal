package com.xss.libraryfinal.controller;


import com.xss.libraryfinal.constants.Constants;
import com.xss.libraryfinal.domain.Book;
import com.xss.libraryfinal.domain.BookType;
import com.xss.libraryfinal.global.FileUtil;
import com.xss.libraryfinal.global.PageBean;
import com.xss.libraryfinal.mapper.BookMapper;
import com.xss.libraryfinal.mapper.BookTypeMapper;
import com.xss.libraryfinal.service.BookService;
import com.xss.libraryfinal.service.BookTypeService;
import com.xss.libraryfinal.vo.BookManageView;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.UUID;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookTypeService bookTypeService;

    @Autowired
    private PageBean<Book> pageBean;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookTypeMapper bookTypeMapper;

    /*  接受页面的信息来返回页面数据*/
    @GetMapping("/pagebean")
    @ResponseBody
    public PageBean<Book> pageBean(BookManageView bookManageView) {
        return bookService.pageBean(bookManageView);
    }

    /* 接受传过来的新增的书本信息*/
    @PostMapping("/dobook")
    public String addBook(
            @RequestParam("bookicon") MultipartFile file,
            @RequestParam("bookname") String bookname,
            @RequestParam("bookauthor") String bookauthor,
            @RequestParam("booktypeid") String booktypeid,
            @RequestParam("bookprice") String bookprice,
            @RequestParam("bookpublisher") String bookpublisher,
            @RequestParam("bookabstract") String bookabstract,
            @RequestParam("action") String action,
            @RequestParam("bookid") String bookid,
            @RequestParam("bookstatus") String bookstatus,
            HttpServletRequest request
    ) {

        String fileName = file.getOriginalFilename();
        //将request转成上下文
        RequestContext req = new ServletRequestContext(request);
        //定义保存的父路径
        String Dir = this.getClass().getClassLoader().getResource("").getPath();
        String parentDir = Dir + "/static/images/";
        //定义文件的名称
        String realName = UUID.randomUUID().toString() + "-" + fileName;
        //上传文件
        try {
            FileUtil.uploadFile(file.getBytes(), parentDir, realName);
        } catch (Exception e) {
            System.out.println(e);
        }
        String fileAddress = "images/" + realName;
        Book book = new Book();
        if (bookid.equals("1")) {
            book.setBookid(UUID.randomUUID().toString());
        } else {
            book.setBookid(bookid);
        }
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        if (!fileName.equals("")) {
            book.setBookicon(fileAddress);
        } else {
            book.setBookicon("");
        }
        book.setBookabstract(bookabstract);
        if (!bookprice.equals("")) {
            book.setBookprice(new BigDecimal(bookprice));
        }
        book.setBookpublisher(bookpublisher);
        book.setBooktypeid(booktypeid);
        String booktype = bookTypeMapper.selectByPrimaryKey(booktypeid).getBooktype();
        book.setBooktype(booktype);
        book.setBookstatus(new Integer(bookstatus));
        String result = "";
        if (action.equals("add")) {
            bookService.insert(book);
            result = "redirect:success";
        } else if (action.equals("update")) {
            bookMapper.updateByPrimaryKeySelective(book);
            result = "redirect:bookDetails?bookid=" + bookid;
        }
        return result;
    }

    /*返回书本的详细信息*/
    @GetMapping("/bookdetails/{bookid}")
    @ResponseBody
    public Book getBook(@PathVariable String bookid) {
        return bookMapper.selectByPrimaryKey(bookid);
    }

    /*删除书本*/
    @GetMapping("/delete")
    public String deleteBook(@RequestParam String bookid) {
        bookMapper.deleteByPrimaryKey(bookid);
        return "redirect:bookManage";
    }

    /*书本更新*/
    @GetMapping("/bookUpdate")
    public String bookUpdate(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "bookUpdate";
    }

    @GetMapping("/bookManage")
    public String bookManage(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "bookManage";
    }


    @GetMapping("/addBook")
    public String addBook(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "addBook";
    }

    @GetMapping("/bookDetails")
    public String bookDetails() {
        return "bookDetails";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/recommand")
    @ResponseBody
    public int recommand() {
        return bookMapper.getRecommand(Constants.RECOMMANDED);
    }

}
