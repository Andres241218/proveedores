package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.User;
import co.edu.upb.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUsersById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }


}
