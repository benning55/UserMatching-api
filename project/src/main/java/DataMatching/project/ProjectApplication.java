package DataMatching.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	ServiceDiscoveryClient serviceDiscoveryClient;

	@GetMapping("/{id}")
	UserData getData(@PathVariable int id) {
		return serviceDiscoveryClient.getData(id);
	}
}


