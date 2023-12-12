package toy.toyproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Toyproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Toyproject1Application.class, args);
	}

}
