package top.meethigher.step2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "top.meethigher.step2")
@Slf4j
public class Step2 {

    public static void main(String[] args) {
        SpringApplication.run(Step2.class, args);
        log.info("当某个Bean被实例化时，如果实现了Aware接口，那么就会先调用里面的setXXX方法，源码参考\norg.springframework.context.support.ApplicationContextAwareProcessor.invokeAwareInterfaces\n这在需要立即使用ApplicationContext的程序中，使用Aware接口会比@Resource等注解效果更佳");
    }
}
