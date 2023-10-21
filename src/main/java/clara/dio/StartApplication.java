package clara.dio;

import clara.dio.model.User;
import clara.dio.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Clara");
        user.setLastName("Campos");
        user.setUsername("claraccampos");
        user.setPassword("123");
        repository.save(user);

        for(User u: repository.findAll()){
            System.out.println(u);
        }

    }
}
