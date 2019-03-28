package study.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import study.recruit.entity.TblCV;
import study.recruit.model.Response;
import study.recruit.service.CVService;

@Controller
public class CvController extends AbstractController {


    private CVService cvService;

    public CvController(CVService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/api/cv/detail")
    public String getCvDetail(Integer cvId) {
        return cvService.getCvDetail(gson, cvId);
    }

    @GetMapping("/api/cv/list")
    public String getCvList() {
        return cvService.getCvList(gson);
    }

    @PostMapping("/api/cv")
    public String createCv(String cvJson) {
        return cvService.createCv(gson.fromJson(cvJson, TblCV.class));
    }

}
