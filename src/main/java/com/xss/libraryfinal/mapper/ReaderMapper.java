package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.Reader;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderMapper {
    int deleteByPrimaryKey(String readerid);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(String readerid);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);

    Reader findByreaderAccount(Reader reader);

    Reader verify(Reader reader);
}