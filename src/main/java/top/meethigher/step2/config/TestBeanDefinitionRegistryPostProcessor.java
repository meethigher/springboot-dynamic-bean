package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import javax.annotation.Resource;

@Slf4j
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    {
        log.info("testBeanDefinitionRegistryPostProcessor");
    }

    @Resource
    private TestEnvironmentAware testEnvironmentAware;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }
}
