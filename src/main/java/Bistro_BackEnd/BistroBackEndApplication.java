package Bistro_BackEnd;

import Bistro_BackEnd.dao.empleado.MozoDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableWebMvc
public class BistroBackEndApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configApp = SpringApplication.run(BistroBackEndApplication.class, args);
		MozoDao mozoDao = configApp.getBean(MozoDao.class);

		Seeder seeder = new Seeder(mozoDao);
		seeder.plant();
	}


	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}
