package vn.edu.iuh.fit.backend.services.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.JobSkillId;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.backend.services.JobSkillServices;

import java.util.List;

@Service
public class JobSkillBean implements JobSkillServices {

    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Override
    public void addJobSkill(JobSkill jobSkill) {
        JobSkillId jobSkillId = new JobSkillId();
        jobSkillId.setJobId(jobSkill.getJob().getId());
        jobSkillId.setSkillId(jobSkill.getSkill().getId());
        jobSkill.setId(jobSkillId);
        jobSkillRepository.save(jobSkill);
    }

    @Override
    public List<JobSkill> getJobSkillsByJobId(Long jobId) {
        return jobSkillRepository.getJobSkillsByJobId(jobId);
    }
}
