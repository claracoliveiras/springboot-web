package clara.dio;

import clara.dio.model.User;
import clara.dio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Value("${spring.config.name}")
    private String configName;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("spring.config.name: " + configName);
        for(User u: repository.findAll()){
            System.out.println(u);
        }

    }
}
