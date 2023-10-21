package clara.dio.controller;

import clara.dio.repository.UserRepository;
import clara.dio.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> list(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody User user){
        repository.save(user);
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody User user) {
        repository.save(user);
    }

    @GetMapping("/users/{username}")
    public User find(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

}
