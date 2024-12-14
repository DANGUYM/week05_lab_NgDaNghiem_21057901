package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.CandidateSkillId;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    @Query("SELECT cs FROM CandidateSkill cs JOIN FETCH cs.skill WHERE cs.can.id = :canId")
    List<CandidateSkill> findByCandidateIdWithSkill(Long canId);
}
