package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@Slf4j
public class TestBeanDefinitionRegistryPostProcessorWithResourceApplicationContext implements BeanDefinitionRegistryPostProcessor {

    {
        log.info("testBeanDefinitionRegistryPostProcessorWithResourceApplicationContext");
    }

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info(applicationContext.getApplicationName());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
