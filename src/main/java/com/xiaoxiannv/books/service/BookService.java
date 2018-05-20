package com.xiaoxiannv.books.service;

import com.xiaoxiannv.books.mapper.BookMapper;
import com.xiaoxiannv.books.po.Book;
import com.xiaoxiannv.books.po.BookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 通过分类的标号找书
     * @param sort
     * @return
     */
    public List<Book> findBySort(int sort){

        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andBookSortEqualTo(sort);
        //return bookMapper.findJava();
        return bookMapper.selectByExample(bookExample);
    }


    /**
     * 插入书
     * @param book
     */
  /*  public void insert(Book book){
        bookMapper.insert(book);
    }*/


    /**
     * 修改下载次数
     * @param bookId
     */
   /* public void addDown(int bookId){
        Book book = bookMapper.selectByPrimaryKey(bookId);
        book.setBookDown(book.getBookDown()+1);
        bookMapper.updateByPrimaryKey(book);
    }*/


}
