package com.bookstore.controller;


import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookService BookService;


    @RequestMapping(value = "/getBooksByType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody//响应体  用于向前端返回数据
    public Map<String,Object> getBooksByType(@RequestBody/*请求体。用于接收前端传来的数据*/ Map<String,Object> map, HttpServletRequest request){

        Map<String,Object> ResponseMap = new HashMap<>();
        try {
            List<Book> bookList=BookService.getBooksByType((String)map.get("bookType"));
            if(bookList.isEmpty()) {
                ResponseMap.put("state",false);
                ResponseMap.put("message","没有该类型书籍。");
                ResponseMap.put("data",bookList);
            }else{
                ResponseMap.put("state",true);
                ResponseMap.put("message","查询成功。");
                ResponseMap.put("data",bookList);
            }
        }catch (Exception e){
            System.out.println("error");
            System.out.println(e.getMessage());

        }
        return ResponseMap;//返回给前端的数据
    }

    @RequestMapping(value = "/admin/addBook")
    @ResponseBody
    public ModelAndView addBook(HttpServletRequest request, Book book , MultipartFile pictureFile) throws Exception{
        ModelAndView responseMap = new ModelAndView();

        if (book!=null || pictureFile != null) {
            //使用UUID给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            //获取文件的扩展名
            String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
            //设置图片上传路径
            String url = request.getSession().getServletContext().getRealPath("/views/assets/i/upload");
            System.out.println(url);
            //以绝对路径保存重名命后的图片
            pictureFile.transferTo(new File(url + "/" + name + "." + ext));
            //保存到数据库的图片路径
            String dataPath = "/views/assets/i/upload/" + name + "." + ext;

            book.setImage(dataPath);

            try {
                BookService.addABook(book);
                responseMap.addObject("message","添加成功");
            }catch (Exception e){
                System.out.println(e.getMessage());
                responseMap.addObject("message","添加时出错,请检查数据格式");
            }
        }else {
            responseMap.addObject("message","添加失败，请检查数据是否为空");
        }

        responseMap.setViewName("admin-addBook");

        return responseMap;
    }

}
