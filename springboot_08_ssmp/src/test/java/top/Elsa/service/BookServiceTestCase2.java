package top.Elsa.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.pojo.Book;
import top.Elsa.service.impl.BookServiceImpl2;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/20--12:08
 * @Description
 */
@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    IBookService bookService = new BookServiceImpl2();
    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("神秘岛");
        book.setType("科幻");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说，xxxxx");
        bookService.save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setName("神秘岛");
        book.setType("科幻1");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说。");
        bookService.updateById(book);
    }

    @Test
    public void testDelete() {
        bookService.removeById(13);
    }

    @Test
    public void testGetById() {
        bookService.getById(1);
    }

    @Test
    public void testGetAll() {
         bookService.list();
    }

    @Test
    public void getPage() {
        IPage<Book> page = new Page(2, 5);
        bookService.page(page);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getRecords() = " + page.getRecords());
    }
}
