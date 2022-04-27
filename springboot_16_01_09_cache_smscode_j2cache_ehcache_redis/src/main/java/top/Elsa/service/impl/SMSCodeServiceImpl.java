package top.Elsa.service.impl;

import net.oschina.j2cache.CacheChannel;
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
    // 1.定义一个缓存
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String phone) {
        String code = codeUtils.generateCode(phone);
        cacheChannel.set("sms", phone, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        if (smsCode == null) {
            return false;
        }
        // 取出缓存中的验证码并与传递过来的验证码比对，如果相同，返回true，否则，返回false
        // 用户填写的验证码
        String code = smsCode.getCode();
        // 缓存中存的验证码
        String cacheCode = cacheChannel.get("sms", smsCode.getPhone()).asString();
        return code.equals(cacheCode);
    }
}
