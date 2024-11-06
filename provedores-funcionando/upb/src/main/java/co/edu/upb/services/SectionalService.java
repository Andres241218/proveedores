package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Sectional;
import co.edu.upb.repository.SectionalRepository;


@Service
public class SectionalService {

    private final SectionalRepository sectionalRepository;


    public SectionalService(SectionalRepository sectionalRepository ) {
        this.sectionalRepository = sectionalRepository;
    }

    public Optional<Sectional> getSectionalsById(long id) {
        return sectionalRepository.findById(id);
    }

    public List<Sectional> getAllSectional() {
        return sectionalRepository.findAll();
    }


}
