package top.Elsa;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// jetcache启用缓存的主开关
@EnableCreateCacheAnnotation
// 开启方法缓存注解
@EnableMethodCache(basePackages = "top.jacktgq")
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}
