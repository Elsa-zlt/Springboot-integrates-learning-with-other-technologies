package top.Elsa.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/19--13:00
 * @Description
 */
@Component
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
