package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Experience;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServices {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    public void deleteById(Long id) {
        experienceRepository.deleteById(id);
    }
}
