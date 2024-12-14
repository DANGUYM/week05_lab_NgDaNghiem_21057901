package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.JobSkill;

import java.util.List;

public interface JobSkillServices {
    void addJobSkill(JobSkill jobSkill);

    List<JobSkill> getJobSkillsByJobId(Long jobId);
}
