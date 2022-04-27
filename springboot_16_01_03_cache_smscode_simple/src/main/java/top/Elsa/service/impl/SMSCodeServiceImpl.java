package top.Elsa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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

    @Override
    // @Cacheable(value = "cacheSpace", key = "#phone")
    // 这里@Cacheable注解不适用，因为@Cacheable注解的功能是：如果缓存中没有值就去执行一次方法，然后将值存到缓存中，
    // 如果有值就直接从缓存中取值并返回，并不会执行方法，因而缓存中值不会发生改变。
    // 而用户点击界面发送一次验证码就调用了一次该方法，需要获取到新的验证码。
    // 使用新的缓存注解@CachePut可以解决这个问题，每次调用都会执行方法，向缓存中存新的值并返回
    @CachePut(value = "cacheSpace", key = "#phone")
    public String sendCodeToSMS(String phone) {
        return codeUtils.generateCode(phone);
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
        String cacheCode = codeUtils.getCodeByPhoneFromCache(smsCode.getPhone());
        return code.equals(cacheCode);
    }
}
