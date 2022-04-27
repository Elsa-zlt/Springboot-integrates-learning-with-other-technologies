package top.Elsa.dao.impl;

import org.springframework.stereotype.Repository;
import top.Elsa.dao.BookDao;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--22:26
 * @Description
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao is running...");
    }
}
