package co.edu.upb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upb.entities.Suppliers;


public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
    Suppliers findBySuppliersName(String suppliersName);
    Suppliers findBySuppliersNit(String suppliersNit);
    void save(Optional<Suppliers> supplier);
}
