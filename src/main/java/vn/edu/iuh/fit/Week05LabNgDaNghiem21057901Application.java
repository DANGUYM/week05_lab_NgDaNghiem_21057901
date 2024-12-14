package vn.edu.iuh.fit;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week05LabNgDaNghiem21057901Application {

    public static void main(String[] args) {
        SpringApplication.run(Week05LabNgDaNghiem21057901Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Bean
    CommandLineRunner initData(){
        return args -> {

            List<Skill> skills = new ArrayList<>();
            skills.add(new Skill("Java","Java programming language", (byte) 1));
            skills.add(new Skill("Python","Python programming language", (byte) 1));
            skills.add(new Skill("C#","C# programming language", (byte) 1));
            for (Skill skill:skills){
                skillRepository.save(skill);
                System.out.println("Added: "+skill);
            }


            Random rnd =new Random();
            for (int i = 1; i < 1000; i++) {
                Address add = new Address(rnd.nextInt(1,1000)+"","Quang Trung","HCM",
                        rnd.nextInt(70000,80000)+"", CountryCode.VN);
                addressRepository.save(add);
                Candidate can=new Candidate("Name #"+i,
                        LocalDate.of(1998,rnd.nextInt(1,13),rnd.nextInt(1,29)),
                        add,
                        rnd.nextLong(1111111111L,9999999999L)+"",
                        "email_"+i+"@gmail.com");
                candidateRepository.save(can);
                System.out.println("Added: " +can);
            }
        };
    }

}
