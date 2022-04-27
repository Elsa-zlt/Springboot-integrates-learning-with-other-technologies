package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.mapper.BookMapper;

@SpringBootTest
class SqlApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById() {
        bookMapper.selectById(1);
    }

}
