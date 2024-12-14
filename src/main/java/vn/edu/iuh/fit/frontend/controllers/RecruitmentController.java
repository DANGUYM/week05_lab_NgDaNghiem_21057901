package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.services.CompanyServices;
import vn.edu.iuh.fit.backend.services.JobServices;
import vn.edu.iuh.fit.backend.services.JobSkillServices;
import vn.edu.iuh.fit.backend.services.SkillServices;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/recruitments")
public class RecruitmentController {

    @Autowired
    private JobServices jobService;

    @Autowired
    private CompanyServices companyService;

    @Autowired
    private JobSkillServices jobSkillService;

    @Autowired
    private SkillServices skillService;
    @GetMapping("/new")
    public String showRecruitmentForm(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        for (Job job : jobs) {
            companyService.getCompanyById(job.getCompany().getId()).ifPresent(job::setCompany);

            HashSet<JobSkill> jobSkills = new HashSet<>(jobSkillService.getJobSkillsByJobId(job.getId()));
            for (JobSkill jobSkill : jobSkills) {
                skillService.findById(jobSkill.getSkill().getId()).ifPresent(jobSkill::setSkill);
            }

            job.setJobSkills(new HashSet<>(jobSkillService.getJobSkillsByJobId(job.getId())));

        }
        model.addAttribute("jobs", jobs);

        return "recruitments/new";
    }
}
