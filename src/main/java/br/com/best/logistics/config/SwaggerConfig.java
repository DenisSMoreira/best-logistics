package br.com.best.logistics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Component
@EnableSwagger
public class SwaggerConfig {
	public static final String DEFAULT_INCLUDE_PATTERNS = ".*/logistics.*";

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).includePatterns(DEFAULT_INCLUDE_PATTERNS)
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		final ApiInfo apiInfo = new ApiInfo("Best Logistics Automation Core API", 
				"Api de logistica. Onde sua principal tarefa é inovar o sistema de entregas visando sempre o menor custo.", null, "denis.soares.moreira@gmail.com",
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");
		return apiInfo;
	}

}