package top.Elsa.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.pojo.Book;
import top.Elsa.service.impl.BookServiceImpl;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/20--12:08
 * @Description
 */
@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    BookService bookService = new BookServiceImpl();
    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("神秘岛");
        book.setType("科幻");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说，是其三部曲的第三部，全书共3部62章。");
        bookService.save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(16);
        book.setName("神秘岛");
        book.setType("科幻1");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说。");
        bookService.update(book);
    }

    @Test
    public void testDelete() {
        bookService.delete(16);
    }

    @Test
    public void testGetById() {
        bookService.getById(1);
    }

    @Test
    public void testGetAll() {
        bookService.getAll();
    }

    @Test
    public void getPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getRecords() = " + page.getRecords());
    }
}
