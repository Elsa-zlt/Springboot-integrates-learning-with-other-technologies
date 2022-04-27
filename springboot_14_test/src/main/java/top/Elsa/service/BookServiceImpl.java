package top.Elsa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.Elsa.mapper.BookMapper;
import top.Elsa.pojo.Book;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/24--1:04
 * @Description
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
}
