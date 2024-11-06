package co.edu.upb.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upb.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {


}