package com.homedo.as;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by quyang on 2018/4/23.
 */
public class MyServletInitializer extends SpringBootServletInitializer{

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ApiApplication.class);
    }
}
