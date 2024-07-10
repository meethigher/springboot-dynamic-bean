package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.meethigher.step1.config.TestApplicationContextAware;
import top.meethigher.step1.config.TestBeanDefinitionRegistryPostProcessor;
import top.meethigher.step1.config.TestEnvironmentAware;

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
        return new TestApplicationContextAware();
    }

    @Bean
    public EnvironmentAware testEnvironmentAware() {
        return new TestEnvironmentAware();
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessor() {
        return new TestBeanDefinitionRegistryPostProcessor();
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessorWithApplicationContext() {
        return new TestBeanDefinitionRegistryPostProcessorWithApplicationContext();
    }

    @Bean
    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessorWithEnvironment() {
        return new TestBeanDefinitionRegistryPostProcessorWithEnvironment();
    }

//    @Bean
//    public BeanDefinitionRegistryPostProcessor testBeanDefinitionRegistryPostProcessorWithResourceApplicationContext() {
//        return new TestBeanDefinitionRegistryPostProcessorWithResourceApplicationContext();
//    }
}
