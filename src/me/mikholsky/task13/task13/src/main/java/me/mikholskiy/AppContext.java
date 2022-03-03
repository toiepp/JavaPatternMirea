package me.mikholskiy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"me.mikholskiy"})
@PropertySource({"classpath:application.yml"})
public class AppContext {
}
