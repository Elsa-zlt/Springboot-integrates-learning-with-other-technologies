package top.Elsa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/23--15:33
 * @Description
 */
//@Component
@ConfigurationProperties(prefix = "server-config")
@Data
// 2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    // 设置具体的规则
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 1000, message = "最小值不能低于1000")
    private int port;
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timeout;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
