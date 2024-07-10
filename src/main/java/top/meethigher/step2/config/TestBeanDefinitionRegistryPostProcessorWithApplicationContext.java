package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class TestBeanDefinitionRegistryPostProcessorWithApplicationContext implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    {
        log.info("testBeanDefinitionRegistryPostProcessorWithApplicationContext");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("testBeanDefinitionRegistryPostProcessorWithApplicationContext postProcessBeanDefinitionRegistry -- {}", registry != null);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("testBeanDefinitionRegistryPostProcessorWithApplicationContext postProcessBeanFactory -- {}", beanFactory != null);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("testBeanDefinitionRegistryPostProcessorWithApplicationContext setApplicationContext -- {}", applicationContext != null);
        this.applicationContext = applicationContext;
    }
}
