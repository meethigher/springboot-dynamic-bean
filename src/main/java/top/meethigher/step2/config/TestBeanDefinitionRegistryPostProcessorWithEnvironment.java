package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

@Slf4j
public class TestBeanDefinitionRegistryPostProcessorWithEnvironment implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    {
        log.info("testBeanDefinitionRegistryPostProcessorWithEnvironment");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("testBeanDefinitionRegistryPostProcessorWithEnvironment postProcessBeanDefinitionRegistry -- {}", registry != null);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("testBeanDefinitionRegistryPostProcessorWithEnvironment postProcessBeanFactory -- {}", beanFactory != null);
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("testBeanDefinitionRegistryPostProcessorWithEnvironment setEnvironment -- {}", environment != null);
        this.environment = environment;
    }
}
