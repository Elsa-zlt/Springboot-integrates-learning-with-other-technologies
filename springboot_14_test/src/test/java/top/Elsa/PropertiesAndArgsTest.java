package top.Elsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import top.Elsa.pojo.BookCase;

// properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
// args属性可以为当前测试用例添加临时的命令行参数
//@SpringBootTest(args = {"--test.prop=testValue2"})
// 优先级排序： args > properties > 配置文件
@SpringBootTest(args = {"--test.prop=testValue2"}, properties = {"test.prop=testValue1"})
class PropertiesAndArgsTest {
    @Value("${test.prop}")
    private String prop;
    @Autowired
    private BookCase bookCase;
    @Test
    public void testProperties() {
        System.out.println("prop = " + prop);
        System.out.println("bookCase = " + bookCase);
    }
}
