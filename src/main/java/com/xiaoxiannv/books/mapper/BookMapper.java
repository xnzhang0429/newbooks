package com.xiaoxiannv.books.mapper;

import com.xiaoxiannv.books.po.Book;
import com.xiaoxiannv.books.po.BookExample;

import java.util.HashMap;
import java.util.List;

import com.xiaoxiannv.books.pojo.SuperBook;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    //List<Book> findJava();

    //Book findBookByName(HashMap map);

}