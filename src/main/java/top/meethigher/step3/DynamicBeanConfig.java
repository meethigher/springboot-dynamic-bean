package top.meethigher.step3;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态配置bean
 *
 * @author chenchuancheng
 * @since 2024/07/11 22:50
 */
@Configuration
public class DynamicBeanConfig implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ServletRegistrationBean.class);
        builder.addConstructorArgValue(new ProxyServlet());
        builder.addConstructorArgValue(environment.getProperty("proxy.servletUrl"));
        Map<String, String> initParams = new HashMap<>();
        initParams.put("targetUri", environment.getProperty("proxy.targetUrl"));
        initParams.put("log", "true");
        builder.addPropertyValue("initParameters", initParams);
        builder.addPropertyValue("name", environment.getProperty("proxy.name"));
        registry.registerBeanDefinition("proxyServlet", builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
