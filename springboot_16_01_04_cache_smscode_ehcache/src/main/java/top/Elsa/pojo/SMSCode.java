package top.Elsa.pojo;

import lombok.Data;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:14
 * @Description 存储手机号和验证码的实体类
 */
@Data
public class SMSCode {
    private String phone;
    private String code;
}
