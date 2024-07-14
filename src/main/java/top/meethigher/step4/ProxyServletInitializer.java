package top.meethigher.step4;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProxyServletInitializer implements ServletContextInitializer {

    private final Environment environment;

    public ProxyServletInitializer(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerProxyServlet(servletContext,environment.getProperty("proxy.name"),environment.getProperty("proxy.targetUrl"));
    }

    private void registerProxyServlet(ServletContext servletContext, String name, String targetUri) {
        ProxyServlet proxyServlet = new ProxyServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet(name + "ProxyServlet", proxyServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/" + name + "/*");
        
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("targetUri", targetUri);
        initParameters.put("log", "true");
        registration.setInitParameters(initParameters);
    }
}