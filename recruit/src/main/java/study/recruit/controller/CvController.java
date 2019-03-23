package study.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        return gson.toJson(cvService.getCvDetailCan(cvId));
    }

    @GetMapping("/api/cv/list")
    public String getCvList() {
        return cvService.getCvListCan(gson);
    }

}
