package com.okta.spring.springbootkbe;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringbootkbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootkbeApplication.class, args);
	}


	@Bean
	ApplicationRunner init(KayakRepository kayakRepository){
		Object[][] data = {
				{"sea", "Andrew", 300.12, "NDK"},
				{"creek", "Andrew", 100.75, "Piranha"},
				{"loaner", "Andrew", 75, "Necky"}
		};
		return args -> {
			kayakRepository.deleteAll().thenMany(Flux.just(data).map(array-> {
				return new Kayak((String) array[0], (String) array[1], (Number) array[2], (String) array[3]);
			}).flatMap(kayakRepository::save)).thenMany(kayakRepository.findAll()).subscribe(kayak -> System.out.println("Saving"+kayak.toString()));

		};



}
}
