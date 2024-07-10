package top.meethigher.step2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;


@Slf4j
public class TestEnvironmentAware implements EnvironmentAware {

    {
        log.info("testEnvironmentAware");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("setEnvironment");
    }
}
