package top.Elsa.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.Elsa.controller.utils.CodeUtils;
import top.Elsa.pojo.SMSCode;
import top.Elsa.service.SMSCodeService;

import java.util.concurrent.TimeUnit;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:16
 * @Description
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;

    // 1、定义一个缓存
    // remote方案
    // @CreateCache(area="sms", name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS)
    // 本地方案（查看源码知晓，如果不指定cacheType = CacheType.LOCAL，默认为远程。）
    // @CreateCache(name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)

    // 还可以指定远程和本地两种缓存方案共存
    @CreateCache(name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH)
    private Cache<String, String> jetCache;

    @Override
    public String sendCodeToSMS(String phone) {
        String code = codeUtils.generateCode(phone);
        // 2、向缓存中存值
        jetCache.put(phone, code);
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
        // 3、获取缓存中存的验证码
        String cacheCode = jetCache.get(smsCode.getPhone());
        return code.equals(cacheCode);
    }
}
