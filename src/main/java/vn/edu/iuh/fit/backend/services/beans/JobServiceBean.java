// JobServiceImpl.java
package vn.edu.iuh.fit.backend.services.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.exceptions.ResourceNotFoundException;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.JobSkillId;
import vn.edu.iuh.fit.backend.repositories.JobRepository;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.backend.services.JobServices;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceBean implements JobServices {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        if (job.getId() == null) {
            throw new IllegalArgumentException("Job ID cannot be null");
        }
        Job existingJob = jobRepository.findById(job.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + job.getId()));
        existingJob.setJobName(job.getJobName());
        existingJob.setJobDesc(job.getJobDesc());
        existingJob.setCompany(job.getCompany());
        return jobRepository.save(existingJob);
    }

    @Override
    public void deleteJob(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
        jobRepository.delete(job);
    }

    @Override
    public void addSkillsToJob(Long jobId, List<Long> skillIds, List<Byte> skillLevels) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + jobId));

        for (int i = 0; i < skillIds.size(); i++) {
            Long skillId = skillIds.get(i);
            Byte level = skillLevels.get(i);
            JobSkill jobSkill = new JobSkill();
            JobSkillId id = new JobSkillId();
            id.setJobId(jobId);
            id.setSkillId(skillId);
            jobSkill.setId(id);
            jobSkill.setJob(job);
            jobSkill.setSkillLevel(level);
            jobSkillRepository.save(jobSkill);
        }
    }

    @Override
    public List<Job> findByCompany_Id(Long companyId) {
        return jobRepository.findByCompany_Id(companyId);
    }

    @Override
    public void addJobSkill(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
    }

    @Override
    public List<JobSkill> getJobSkillsByJobId(Long jobId) {
        return jobSkillRepository.getJobSkillsByJobId(jobId);
    }

    @Override
    public List<Job> findJobsByCandidateSkills(Long candidateId) {
        return jobRepository.findJobsByCandidateSkills(candidateId);
    }
}
