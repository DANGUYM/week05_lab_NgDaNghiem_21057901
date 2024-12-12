package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServices {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

}