package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSet() {
        ValueOperations valueOperations = redisTemplate.opsForValue();

        valueOperations.set("age", "41");
    }
    @Test
    public void testGet() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println("age = " + valueOperations.get("age"));
        System.out.println("username = " + valueOperations.get("username"));
    }

    @Test
    public void hSet() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user", "name", "空条承太郎");
        hashOperations.put("user", "age", "17");
        hashOperations.put("user", "替身使者", "白金之星");
    }

    @Test
    public void hGet() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        System.out.println(hashOperations.get("user", "name"));
    }
}
