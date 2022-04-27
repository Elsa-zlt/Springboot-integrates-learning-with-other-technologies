package top.Elsa.service;

import top.Elsa.pojo.SMSCode;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:15
 * @Description
 */
public interface SMSCodeService {
    String sendCodeToSMS(String phone);

    boolean checkCode(SMSCode smsCode);
}
