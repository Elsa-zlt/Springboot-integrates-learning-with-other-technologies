package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import top.Elsa.pojo.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class H2ApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testH2Select() {
        String sql = "select * from tbl_book";

        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };
        List<Book> bookList = jdbcTemplate.query(sql, rm);
        bookList.forEach(System.out::println);
    }

    @Test
    public void testH2Save() {
        String sql = "insert into tbl_book values(?, ? ,? ,?)";
        jdbcTemplate.update(sql, 5, "啊哈算法", "计算机", "数据结构和算法");
    }
}
