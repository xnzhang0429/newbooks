package com.xiaoxiannv.books.controller;

import com.xiaoxiannv.books.po.Book;
import com.xiaoxiannv.books.service.BookService;
import com.xiaoxiannv.books.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/java")//url

public class JavaController {
    @Autowired
    private BookService bookService;

    /**
     * 返回Java基础界面
     * @param model
     * @return
     */
    @RequestMapping("/javabase")
    public String javaBase(Model model){  //名字无所谓，通过上面的url调用
        model.addAttribute("topmenue","java");
        model.addAttribute("leftmenue","javabase");

        List<Book> books = bookService.findBySort(Util.javaBase);//工具类，对应着dict表中id号

        if(books==null||books.size()==0){
            model.addAttribute("javaBase",null);
        }
        else{
            model.addAttribute("javaBase",books);
        }

        return "javaBase";
    }

    /**
     * 返回Java框架界面
     * @param model
     * @return
     */
    @RequestMapping("/javaframe")
    public String javaFrame(Model model){
        model.addAttribute("topmenue","java");
        model.addAttribute("leftmenue","javaframe");

        List<Book> books = bookService.findBySort(Util.javaFrame);

        if(books==null||books.size()==0){
            model.addAttribute("javaFrame",null);
        }
        else{
            model.addAttribute("javaFrame",books);
        }

        return "javaFrame";

    }
}
