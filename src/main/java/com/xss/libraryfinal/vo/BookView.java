package com.xss.libraryfinal.vo;

import com.xss.libraryfinal.constants.Constants;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookView {
    private int currentPage;
    private int currentCount= Constants.USERCURRENTCOUNT;
    private String booktypeid;
    private int pagestart;

    public int getPagestart() {
        return (currentPage-1)*currentCount;
    }
}
