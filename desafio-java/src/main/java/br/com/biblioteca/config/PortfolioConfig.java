package br.com.biblioteca.config;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import br.com.biblioteca.mapper.ProjectMapper;




@Configuration
public class PortfolioConfig {

	@Bean
	public ProjectMapper createProjectMapper() {
		return new ProjectMapper();
	}
	
		
}
