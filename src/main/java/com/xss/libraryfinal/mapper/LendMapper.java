package com.xss.libraryfinal.mapper;

import com.xss.libraryfinal.domain.Lend;

public interface LendMapper {
    int deleteByPrimaryKey(String lendid);

    int insert(Lend record);

    int insertSelective(Lend record);

    Lend selectByPrimaryKey(String lendid);

    int updateByPrimaryKeySelective(Lend record);

    int updateByPrimaryKey(Lend record);
}