package top.meethigher.step1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static top.meethigher.step1.Step1.list;

/**
 * 验证下面几种Bean的注册顺序
 * ApplicationContextAware
 * EnvironmentAware
 * BeanDefinitionRegistryPostProcessor
 *
 * @author chenchuancheng
 * @since 2024/07/08 22:51
 */
@Configuration
@Slf4j
public class TestBeanLoadOrder {

    {
        log.info("testBeanLoadOrder");
    }

    @Bean
    public Map<String, String> testMap() {
        return new HashMap<String, String>() {{
            {
                log.info("regular map");
            }
        }};
    }


    @Bean
    public ApplicationContextAware testApplicationContextAware() {
        list.add(ApplicationContextAware.class);
        return new TestApplicationContextAware();
    }

    @Bean
    public EnvironmentAware testEnvironmentAware() {
        list.add(EnvironmentAware.class);
        return new TestEnvironmentAware();
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessor() {
        list.add(BeanDefinitionRegistryPostProcessor.class);
        return new TestBeanDefinitionRegistryPostProcessor();
    }

//    /**
//     * 在springboot中，被依赖的bean会被先加载
//     * 通过创建bean时，@DependsOn或者@Qualifier可以告知springboot某个bean的生成是依赖于其他bean的
//     */
//    @Bean
//    @DependsOn("testEnvironmentAware")
//    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessor(@Qualifier("testEnvironmentAware") EnvironmentAware testEnvironmentAware) {
//        list.add(BeanDefinitionRegistryPostProcessor.class);
//        return new TestBeanDefinitionRegistryPostProcessor();
//    }
}
