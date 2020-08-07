package com.xss.libraryfinal.vo;

import com.xss.libraryfinal.constants.Constants;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Data
@Component
public class BookManageView {
    private String bookname;
    private String bookauthor;
    private String booktypeid;
    private BigDecimal bookpriceMin;
    private BigDecimal bookpriceMax;
    private int currentPage;
    private int currentCount= Constants.CURRENTCOUNT;
    private int pagestart;

    public int getPagestart() {
        return (currentPage-1)*currentCount;
    }
}
