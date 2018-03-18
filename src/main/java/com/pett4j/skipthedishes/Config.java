package com.pett4j.skipthedishes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Configuration
@ComponentScans(value = { @ComponentScan("com.pett4j.skipthedishes.controller"),
		@ComponentScan("com.pett4j.skipthedishes.jpa"),
		@ComponentScan("com.pett4j.skipthedishes.entity"), @ComponentScan("com.pett4j.skipthedishes.service") })
public class Config {

}
