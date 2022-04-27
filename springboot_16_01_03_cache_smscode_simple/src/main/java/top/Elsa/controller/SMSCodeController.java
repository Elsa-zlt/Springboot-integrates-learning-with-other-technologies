package top.Elsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.Elsa.pojo.SMSCode;
import top.Elsa.service.SMSCodeService;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/13--21:17
 * @Description
 */
@RestController
@RequestMapping("/smscode")
public class SMSCodeController {
    @Autowired
    SMSCodeService smsCodeService;

    @GetMapping("{phone}")
    public String getCode(@PathVariable String phone) {
        return smsCodeService.sendCodeToSMS(phone);
    }

    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
