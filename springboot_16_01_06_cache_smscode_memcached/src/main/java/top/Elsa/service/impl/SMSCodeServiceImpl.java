package top.Elsa.service.impl;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.controller.utils.CodeUtils;
import top.Elsa.pojo.SMSCode;
import top.Elsa.service.SMSCodeService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:16
 * @Description
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    public String sendCodeToSMS(String phone) {
        String code = codeUtils.generateCode(phone);
        try {
            memcachedClient.set(phone, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            code = memcachedClient.get(smsCode.getPhone()).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }
}
