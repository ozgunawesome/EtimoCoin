package se.etimo.etimocoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ozgunayaz on 1/19/17.
 * license: https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

@SpringBootApplication
public class Application {

    @Configuration
    public class WebConfig extends WebMvcConfigurerAdapter {

        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.defaultContentType(MediaType.APPLICATION_JSON);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(Application.class, args);
    }

}
