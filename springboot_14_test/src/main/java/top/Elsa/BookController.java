package top.Elsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.Elsa.pojo.Book;
import top.Elsa.service.IBookService;

import java.util.List;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/23--23:25
 * @Description
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    /*@GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        System.out.println("id = " + id);
        return "getById...";
    }*/

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        System.out.println("id = " + id);
        Book book = new Book();
        book.setId(5);
        book.setName("神秘岛");
        book.setType("科幻");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说，是他写的三部曲之一。");

        return book;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }
}
