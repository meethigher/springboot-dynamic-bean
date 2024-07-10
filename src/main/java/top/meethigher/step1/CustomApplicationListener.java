package top.meethigher.step1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author chenchuancheng
 * @since 2024/07/10 22:48
 */
@Slf4j
public class CustomApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ConfigurableEnvironment environment = ((ApplicationEnvironmentPreparedEvent) event).getEnvironment();
            log.info("Environment initialized: {}", environment);
            String property = environment.getProperty("server.port");
            System.out.println(property);
        } else if (event instanceof ApplicationPreparedEvent) {
            ConfigurableApplicationContext context = ((ApplicationPreparedEvent) event).getApplicationContext();
            log.info("ApplicationContext initialized: {}", context);
        } else {
            log.info(event.toString());
        }
    }
}
