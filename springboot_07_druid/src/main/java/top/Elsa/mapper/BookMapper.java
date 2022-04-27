package top.Elsa.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.Elsa.pojo.Book;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--23:00
 * @Description
 */
@Mapper
public interface BookMapper {
    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
