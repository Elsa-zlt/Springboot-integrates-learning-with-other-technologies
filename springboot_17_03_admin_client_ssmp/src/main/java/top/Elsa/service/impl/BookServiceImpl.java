package top.Elsa.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.mapper.BookMapper;
import top.Elsa.pojo.Book;
import top.Elsa.service.BookService;

import java.util.List;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/20--12:04
 * @Description
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }
}
