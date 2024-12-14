// JobService.java
package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;

import java.util.List;
import java.util.Optional;

public interface JobServices {
    List<Job> getAllJobs();
    Optional<Job> getJobById(Long id);
    Job createJob(Job job);
    Job updateJob(Job job);
    void deleteJob(Long id);

    void addSkillsToJob(Long jobId, List<Long> skillIds, List<Byte> skillLevels);

    List<Job> findByCompany_Id(Long companyId);

    void addJobSkill(JobSkill jobSkill);

    List<JobSkill> getJobSkillsByJobId(Long jobId);

    List<Job> findJobsByCandidateSkills(Long candidateId);
}
