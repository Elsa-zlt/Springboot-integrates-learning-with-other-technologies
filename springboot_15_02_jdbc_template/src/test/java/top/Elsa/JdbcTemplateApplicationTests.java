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
class JdbcTemplateApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void testJdbcTemplateSelect() {
        String sql = "select * from tbl_book";
        // List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        // System.out.println(maps);
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
    void testJdbcTemplateInsert() {
        String sql = "insert into tbl_book values(null, ?, ?, ?)";
        jdbcTemplate.update(sql, "springboot1", "springboot2", "springboot3");
    }
}
