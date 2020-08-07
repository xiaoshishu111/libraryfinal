package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.ReaderLevel;

public interface ReaderLevelMapper {
    int deleteByPrimaryKey(String readerlevelid);

    int insert(ReaderLevel record);

    int insertSelective(ReaderLevel record);

    ReaderLevel selectByPrimaryKey(String readerlevelid);

    int updateByPrimaryKeySelective(ReaderLevel record);

    int updateByPrimaryKey(ReaderLevel record);
}