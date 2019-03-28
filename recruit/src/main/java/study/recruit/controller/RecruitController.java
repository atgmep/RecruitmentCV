package study.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import study.recruit.service.RecruitService;

@Controller
public class RecruitController extends AbstractController {
    private RecruitService recruitService;


    public RecruitController(RecruitService recruitService) {
        this.recruitService = recruitService;
    }


    @GetMapping("/api/recruit/list")
    public String getRecruitList() {
        return recruitService.getRecruitList(gson);
    }

    @PutMapping("/api/apply")
    public String getApplyList(int recruitId) {
        return recruitService.getApplyList(gson, recruitId);
    }

    @PostMapping("/api/recruit")
    public String createRecruit(String name, String description, Double minSalary, Double maxSalary, Long applyFrom, Long applyTo, int departmentId) {
        return recruitService.createRecruit(name, description, minSalary, maxSalary, applyFrom, applyTo, departmentId);
    }

    @PutMapping("/api/recruit")
    public String updateRecruit(int recruitId, String name, String description, Double minSalary, Double maxSalary, Long applyFrom, Long applyTo, int departmentId) {
        return recruitService.updateRecruit(recruitId, name, description, minSalary, maxSalary, applyFrom, applyTo, departmentId);
    }
}
