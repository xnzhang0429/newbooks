package com.xiaoxiannv.books.controller;

import com.xiaoxiannv.books.po.Book;
import com.xiaoxiannv.books.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/java/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 调出添加书界面
     * @param model
     * @param dictId
     * @return
     */
    @RequestMapping("/add/page")
    public String Page(Model model, @RequestParam(value = "dictId") Integer dictId){
        model.addAttribute("belong",dictId);

        return "addBookPage";
    }

    @ResponseBody
    @RequestMapping("/add/do")
    public Map doAdd(Model model,
                     @RequestParam(value = "bookname") String bookname,
                     @RequestParam(value = "booklink") String booklink,
                     @RequestParam(value = "bookpassword") String bookpassword,
                     @RequestParam(value = "user") String user,
                     @RequestParam(value = "sort") Integer sort) {


        Map map = new HashMap();
        try{
            Book book = new Book();
            book.setBookSort(sort);
            book.setBookName(bookname);
            book.setBookLink(booklink);
            book.setBookPassword(bookpassword);
            book.setBookTime(new Date().getTime());
            book.setBookUser(user);
            book.setBookDown(0);

          //  bookService.insert(book);
            map.put("data",1);
            map.put("msg","成功");
            return map;

        }catch (Exception e){
            map.put("data",1);
            map.put("msg","失败");
            return map;

        }
    }

    @RequestMapping("/add/down")
    public void down(@RequestParam(value="bookId") Integer bookId){
       // bookService.addDown(bookId);

    }

}
