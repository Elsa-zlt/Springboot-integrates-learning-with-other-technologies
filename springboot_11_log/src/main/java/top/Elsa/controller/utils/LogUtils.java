package top.Elsa.controller.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/21--17:33
 * @Description
 */
public class LogUtils {
    // 创建记录日志的对象
    protected static Logger log;

    public LogUtils() {
        log = LoggerFactory.getLogger(this.getClass());
    }
}
