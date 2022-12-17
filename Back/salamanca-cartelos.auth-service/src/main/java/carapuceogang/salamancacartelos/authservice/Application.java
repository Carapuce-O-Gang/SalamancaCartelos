package carapuceogang.salamancacartelos.authservice;

import carapuceogang.salamancacartelos.authservice.services.MappingService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		MappingService.addMappings(modelMapper);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
