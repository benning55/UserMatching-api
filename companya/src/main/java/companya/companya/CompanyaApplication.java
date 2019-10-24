package companya.companya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableEurekaClient
//@EntityScan(basePackages = "companyData")
public class CompanyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyaApplication.class, args);
    }

}
