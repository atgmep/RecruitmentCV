package study.recruit.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import study.recruit.common.Methods;
import study.recruit.entity.TblApply;
import study.recruit.entity.TblAward;
import study.recruit.entity.TblCV;
import study.recruit.entity.TblRecruit;
import study.recruit.model.cv.MdlCV;
import study.recruit.model.cv.MdlCVBuilder;
import study.recruit.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class CVService {

    private AdwardRepository adwardRepository;
    private CertificateRepository certificateRepository;
    private CVRepository cvRepository;
    private EducationRepository educationRepository;
    private ExpRepository expRepository;
    private ParticipationRepository participationRepository;
    private ProjectRepository projectRepository;
    private SpecializeRepository specializeRepository;
    private RecruitRepository recruitRepository;
    private ApplyRepository applyRepository;

    public CVService(AdwardRepository adwardRepository, CertificateRepository certificateRepository, CVRepository cvRepository, EducationRepository educationRepository, ExpRepository expRepository, ParticipationRepository participationRepository, ProjectRepository projectRepository, SpecializeRepository specializeRepository, RecruitRepository recruitRepository, ApplyRepository applyRepository) {
        this.adwardRepository = adwardRepository;
        this.certificateRepository = certificateRepository;
        this.cvRepository = cvRepository;
        this.educationRepository = educationRepository;
        this.expRepository = expRepository;
        this.participationRepository = participationRepository;
        this.projectRepository = projectRepository;
        this.specializeRepository = specializeRepository;
        this.recruitRepository = recruitRepository;
        this.applyRepository = applyRepository;
    }
//
//    public MdlCV getCvDetail(Integer cvId) {
//        Optional<TblCV> optional = cvRepository.findById(cvId);
//        MdlCV mdlCV = null;
//        MdlCVBuilder mdlCVBuilder = new MdlCVBuilder();
//        if (optional.isPresent()) {
//            mdlCV = mdlCVBuilder.buildFull(optional.get(), adwardRepository, certificateRepository, educationRepository, expRepository, participationRepository, projectRepository, specializeRepository);
//        }
//        return mdlCV;
//    }


    public String getCvDetail(Gson gson, Integer cvId) {
        return gson.toJson(cvRepository.findById(cvId).get());
    }

    public String getCvList(Gson gson) {
        Methods methods = new Methods();
        List<TblCV> tblCVList = cvRepository.findAllByCandidate(methods.getUser().getCandidate());
        if (tblCVList.isEmpty()) {
            return "empty";
        } else {
            MdlCVBuilder mdlCVBuilder = new MdlCVBuilder();
            String result = gson.toJson(mdlCVBuilder.buildListEntry(tblCVList.get(0)));
            for (int i = 1; i < tblCVList.size(); i++) {
                result += ("|" + gson.toJson(mdlCVBuilder.buildListEntry(tblCVList.get(i))));
            }
            return result;
        }
    }


    public String createCv(TblCV tblCV) {
        cvRepository.save(tblCV);
        return "ok";
    }

    public String applyCv(int cvId, int recruitId) {
        TblCV tblCV = cvRepository.findById(cvId).get();
        TblRecruit tblRecruit = recruitRepository.findById(recruitId).get();
        TblApply tblApply = new TblApply();
        tblApply.setCv(tblCV);
        tblApply.setRecruit(tblRecruit);
        applyRepository.save(tblApply);
        return tblApply.getId() + "";
    }
}
