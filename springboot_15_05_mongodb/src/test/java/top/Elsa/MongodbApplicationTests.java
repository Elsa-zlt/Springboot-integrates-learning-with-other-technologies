package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import top.Elsa.pojo.Book;

import java.util.List;

@SpringBootTest
class MongodbApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(2);
        book.setName("springboot2");
        book.setType("springboot2");
        book.setDescription("springboot2");
        mongoTemplate.save(book);
    }

    @Test
    public void testFindAll() {
        List<Book> books = mongoTemplate.findAll(Book.class);
        books.forEach(System.out::println);
    }
}
