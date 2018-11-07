package com.atwa.base.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class FreemarkerConfig {

	private static Logger log = LoggerFactory.getLogger(FreemarkerConfig.class);

	

	@Bean
	@Primary
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates/");
		return bean;
	}
	
	
//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
//        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
//        factory.setTemplateLoaderPaths("classpath:templates", "src/main/resource/templates");
//        factory.setDefaultEncoding("UTF-8");
//        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
//        result.setConfiguration(factory.createConfiguration());
//        return result;
//    }
}
