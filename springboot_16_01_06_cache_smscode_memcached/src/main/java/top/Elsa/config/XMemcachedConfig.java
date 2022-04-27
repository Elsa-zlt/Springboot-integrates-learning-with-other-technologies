package top.Elsa.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author Elsa_zlt
 * @Date 2022/4/14--2:15
 * @Description Memcached客户端配置
 */
@Component
public class XMemcachedConfig {
    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(xMemcachedProperties.getAddressList());
        memcachedClientBuilder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        memcachedClientBuilder.setOpTimeout(xMemcachedProperties.getOpTimeout());
        MemcachedClient memcachedClient = memcachedClientBuilder.build();
        return memcachedClient;
    }
}
