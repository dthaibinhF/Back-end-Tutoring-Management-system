package com.ctu.chemis;

import com.ctu.chemis.Repository.SchoolYearsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SchoolYearsRepository.class)
public class ChemisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChemisApplication.class, args);
    }

}
