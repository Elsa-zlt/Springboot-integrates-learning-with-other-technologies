package top.Elsa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.Elsa.pojo.Book;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/24--1:05
 * @Description
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
