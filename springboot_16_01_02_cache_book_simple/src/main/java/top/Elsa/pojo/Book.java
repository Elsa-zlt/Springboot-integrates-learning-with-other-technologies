package top.Elsa.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--22:58
 * @Description
 */
@Component
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
