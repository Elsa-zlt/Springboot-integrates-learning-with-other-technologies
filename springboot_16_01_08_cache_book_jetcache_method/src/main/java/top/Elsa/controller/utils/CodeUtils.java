package top.Elsa.controller.utils;


import com.alicp.jetcache.anno.Cached;
import org.springframework.stereotype.Component;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:21
 * @Description 生成验证码的工具类，位数少于6位左边填充0
 */
@Component
public class CodeUtils {
    private final String padding = "000000";
    // 生成验证码（位数少于6位左边填充0，填充方法1）
    public String generateCode(String phone) {
        int hash = phone.hashCode();
        int encryption = 20228888;
        long result = hash ^ encryption;
        long nowTime = System.nanoTime();
        result = (result ^ nowTime) % 1000000;
        String code = result + "";
        // code = phone;
        // padding.substring(code.length())   code.length()
        //                                         6
        //             0                           5
        //             00                          4
        //             000                         3
        //             000                         3
        //             0000                        2
        //             00000                       1
        //             000000                      0
        code = padding.substring(code.length()) + code;
        // System.out.println(code);
        return code;
    }

    private final String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};
    // 生成验证码（位数少于6位左边填充0，填充方法2）
    public String generateCode1(String phone) {
        int hash = phone.hashCode();
        int encryption = 20228888;
        long result = hash ^ encryption;
        long nowTime = System.nanoTime();
        result = (result ^ nowTime) % 1000000;
        String code = result + "";
        // code = phone;
        // patch[code.length]    code.length()
        //   000000                    0
        //   00000                     1
        //   0000                      2
        //   000                       3
        //   00                        4
        //   0                         5
        //                             6
        code = patch[code.length()] + code;
        // System.out.println(code);
        return code;
    }

    // 根据手机号从缓存中获取验证码，缓存中有的话返回缓存中的值，没有的话就返回null
    @Cached(name = "smsCode", key = "#phone", expire = 10)
    public String getCodeByPhoneFromCache(String phone) {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        CodeUtils codeUtils = new CodeUtils();
        for (int i = 0; i < 200; i++) {
            codeUtils.generateCode("15800830439");
            Thread.sleep((long) Math.random() * 10);
        }
        /*codeUtils.generateCode("");
        codeUtils.generateCode("1");
        codeUtils.generateCode("12");
        codeUtils.generateCode("123");
        codeUtils.generateCode("1234");
        codeUtils.generateCode("12345");
        codeUtils.generateCode("123456");*/
    }
}
