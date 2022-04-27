package top.Elsa.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.Elsa.pojo.Book;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/20--12:49
 * @Description
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
