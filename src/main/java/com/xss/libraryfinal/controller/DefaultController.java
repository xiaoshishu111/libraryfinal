package com.xss.libraryfinal.controller;

import com.xss.libraryfinal.domain.Admin;
import com.xss.libraryfinal.domain.Book;
import com.xss.libraryfinal.domain.BookType;
import com.xss.libraryfinal.domain.Reader;
import com.xss.libraryfinal.global.FileUtil;
import com.xss.libraryfinal.global.PageBean;
import com.xss.libraryfinal.mapper.BookMapper;
import com.xss.libraryfinal.mapper.ReaderMapper;
import com.xss.libraryfinal.service.BookService;
import com.xss.libraryfinal.service.BookTypeService;
import com.xss.libraryfinal.vo.BookView;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/default")
public class DefaultController {
    @Autowired
    BookTypeService bookTypeService;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookService bookService;

    @Autowired
    BookView bookView;

    @Autowired
    ReaderMapper readerMapper;

    @GetMapping("/index")
    public String login() {
        return "index";
    }

    @GetMapping("/userindex")
    public String userindex(HttpServletRequest request) {
        request.setAttribute("booktype", bookTypeService.getRoot());
        request.setAttribute("rankbooks", bookMapper.getList(12));
        return "userindex";
    }

    @PostMapping("/getRecommand")
    @ResponseBody
    public List<Book> getRecommand() {
        return bookMapper.getRecommandBooks();
    }

//    @GetMapping("/getBooks")
//    public String getBooks(@RequestParam String booktypeid, @RequestParam String page, HttpServletRequest request) {
//        bookView.setBooktypeid(booktypeid);
//        bookView.setCurrentPage(new Integer(page));
//        request.setAttribute("pagebean", bookService.UserPageBean(bookView));
//        return "redirect:list?mm=1";
//    }

    @GetMapping("/list")
    public String list(@RequestParam String booktypeid, HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "list";
    }

    @GetMapping("/getBooks")
    @ResponseBody
    public PageBean<Book> getBooks(BookView bookView) {
        return bookService.UserPageBean(bookView);
    }

    @GetMapping("/detail")
    public String detail(@RequestParam String bookid, HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("book", bookMapper.selectByPrimaryKey(bookid));
        request.setAttribute("booktype", bookType);
        return "detail";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "register";
    }


    /*验证账户是否存在*/
    @PostMapping(value = "/readerAccount/{readerAccount}")
    @ResponseBody
    public Reader findByreaderAccount(@PathVariable String readerAccount) {
        Reader reader = new Reader();
        reader.setReaderaccount(readerAccount);
        return readerMapper.findByreaderAccount(reader);
    }

    @PostMapping("/registerdo")
    public String registerdo(@RequestParam MultipartFile file,
                             @RequestParam String readeraccount,
                             @RequestParam String readerpassword,
                             HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        //将request转成上下文
        RequestContext req = new ServletRequestContext(request);
        //定义保存的父路径
        String Dir = this.getClass().getClassLoader().getResource("").getPath();
        String parentDir = Dir + "/static/userimages/";
        //定义文件的名称
        String realName = UUID.randomUUID().toString() + "-" + fileName;
        try {
            FileUtil.uploadFile(file.getBytes(), parentDir, realName);
        } catch (Exception e) {
            System.out.println(e);
        }
        String fileAddress = "userimages/" + realName;
        Reader reader = new Reader();
        reader.setReaderaccount(readeraccount);
        String location="";
        if (readerMapper.findByreaderAccount(reader)==null){
            reader.setReaderpassword(readerpassword);
            reader.setReadericon(fileAddress);
            reader.setReaderid(UUID.randomUUID().toString());
            readerMapper.insert(reader);

            location="userindex";
        }else {
            request.setAttribute("result","no");
            location="register";
        }
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return location;
    }

    @GetMapping("/login")
    public String adminlogin(HttpServletRequest request) {
        return "login";
    }


    @PostMapping("/verify")
    public String verify(Reader reader, HttpSession session,HttpServletRequest request){
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        reader=readerMapper.verify(reader);
        if (reader!=null){
            session.setAttribute("reader",reader);
            request.setAttribute("a",1);
        }
        return "userindex";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,HttpServletRequest request){
        session.removeAttribute("reader");
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "userindex";
    }
}
