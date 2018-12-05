package com.bookstore.controller.viewController;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/adminPage")
public class adminViewController {
    @Autowired
    BookService bookService;

    @RequestMapping(
            value="/",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public ModelAndView getMainPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //获取所有图书种类
        List<String> types = bookService.getBooksType();
        mv.addObject("types",types);

        //获取所有图书
        List<Book> books = bookService.getAllBooks();
        mv.addObject("books",books);

        //设置返回页面
        mv.setViewName("admin-index");
        return mv;
    }

    @RequestMapping(
            value="/getBookByType",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public ModelAndView getBookByType(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        String type = "";
        try {
            type = new String(request.getParameter("bookType").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(type);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //获取该种类所有图书
        List<Book> books = bookService.getBooksByType(type);
        mv.addObject("books",books);

        //获取所有图书种类
        List<String> types = bookService.getBooksType();
        mv.addObject("types",types);

        //设置返回页面
        mv.setViewName("admin-index");
        return mv;
    }

    @RequestMapping(
            value="/getAllOrders",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public ModelAndView getAllPrders(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //获取所有图书种类
        List<String> types = bookService.getBooksType();
        mv.addObject("types",types);

        //设置返回页面
        mv.setViewName("admin-showOrders");
        return mv;
    }

    @RequestMapping(
            value="/addBook",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public ModelAndView addBook(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //获取所有图书种类
        List<String> types = bookService.getBooksType();
        mv.addObject("types",types);

        //设置返回页面
        mv.setViewName("admin-addBook");
        return mv;
    }

    @RequestMapping(
            value="/chargeUser",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8"
    )
    @ResponseBody
    public ModelAndView chargeUser(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        //获取所有图书种类
        List<String> types = bookService.getBooksType();
        mv.addObject("types",types);

        //设置返回页面
        mv.setViewName("admin-chargeUser");
        return mv;
    }

}
