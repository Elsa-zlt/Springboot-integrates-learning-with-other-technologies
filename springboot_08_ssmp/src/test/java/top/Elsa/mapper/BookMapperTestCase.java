package top.Elsa.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.pojo.Book;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/20--0:34
 * @Description
 */
@SpringBootTest
public class BookMapperTestCase {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelectById() {
        bookMapper.selectById(1);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("神秘岛");
        book.setType("科幻");
        book.setDescription("《神秘岛》是法国科幻小说家儒勒·凡尔纳创作的长篇小说，是其三部曲的第三部，全书共3部62章。");

        bookMapper.insert(book);
    }

    @Test
    void testDelete() {
        bookMapper.deleteById(15);
    }

    @Test
    void testGetAll() {
        bookMapper.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page(2, 5);
        bookMapper.selectPage(page, null);
        System.out.println("currentPage:" + page.getCurrent());
        System.out.println("pageSize:" + page.getSize());
        System.out.println("total:" + page.getTotal());
        System.out.println("page:" + page.getPages());
        System.out.println("record:" + page.getRecords());
    }

    @Test
    void testGetByCondition() {
        QueryWrapper<Book> qw = new QueryWrapper();
        qw.like("name", "spring");
        bookMapper.selectList(qw);
    }

    @Test
    void testGetByCondition2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        /*if (name != null) {
            lqw.like(Book::getName, "Spring");
        }*/
        // 等价写法
        lqw.like(name != null, Book::getName, name);
        bookMapper.selectList(lqw);
    }
}
