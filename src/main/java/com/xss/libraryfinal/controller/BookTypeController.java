package com.xss.libraryfinal.controller;

import com.xss.libraryfinal.domain.BookType;
import com.xss.libraryfinal.mapper.BookTypeMapper;
import com.xss.libraryfinal.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/booktype")
public class BookTypeController {
    @Autowired
    BookTypeService bookTypeService;

    @Autowired
    BookTypeMapper bookTypeMapper;

    @GetMapping("/bookType")
    public String bookType(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "bookType";
    }


    @GetMapping("/addBookType")
    public String addBookType(HttpServletRequest request) {
        BookType bookType = bookTypeService.getRoot();
        request.setAttribute("booktype", bookType);
        return "addBookType";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request) {
        String[] booktype = request.getParameterValues("booktype");
        String[] booktypepid=request.getParameterValues("booktypepid");
        String[] booktypeinf=request.getParameterValues("booktypeinf");
        List<BookType> list=new ArrayList<>();
        for (int i=0;i<booktype.length;i++){
            BookType bookType=new BookType();
            bookType.setBooktypeid(UUID.randomUUID().toString());
            bookType.setBooktype(booktype[i]);
            bookType.setBooktypepid(booktypepid[i]);
            bookType.setBooktypeinf(booktypeinf[i]);
            list.add(bookType);
        }
        bookTypeService.banchInsert(list);
        return "redirect:bookType";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String booktypeid){
        bookTypeMapper.deleteByPrimaryKey(booktypeid);
        return "redirect:bookType";
    }

}
