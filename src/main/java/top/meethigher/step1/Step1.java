package top.meethigher.step1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "top.meethigher.step1")
@Slf4j
public class Step1 {

    public final static List<Class<?>> list = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Step1.class);
        application.addListeners(new CustomApplicationListener());
        application.run(args);
        String[] array = new String[list.size()];
        for (Class<?> aClass : list) {
            array[list.indexOf(aClass)] = aClass.getSimpleName();
        }
        log.info("springboot 启动后，先初始化 Environment ，再初始化 ApplicationContext ，可以通过注册 ApplicationListener 验证");
        log.info("Environment 和 ApplicationContext 在注入时，一定不会为空的");
        log.info("测试中这三个 Bean 默认情况下的加载顺序如下\n{}", String.join(" > ", array));
    }
}