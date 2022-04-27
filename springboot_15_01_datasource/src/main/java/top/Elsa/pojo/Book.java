package top.Elsa.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--22:58
 * @Description
 */
@Component
@Data
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
