package study.recruit.model.cv;

import study.recruit.entity.*;
import study.recruit.repository.*;

import java.util.ArrayList;
import java.util.List;

public class MdlCVBuilder {


    public MdlCV buildFull(TblCV tblCV, AdwardRepository adwardRepository, CertificateRepository certificateRepository, EducationRepository educationRepository, ExpRepository expRepository, ParticipationRepository participationRepository, ProjectRepository projectRepository, SpecializeRepository specializeRepository) {
        MdlCV mdlCV = new MdlCV();
        mdlCV.id = tblCV.getId();
        mdlCV.name = tblCV.getName();
        mdlCV.objective = tblCV.getObjective();
        mdlCV.additionalInfo = tblCV.getAdditionalInfo();
        mdlCV.pdfUrl = tblCV.getPdfUrl();
        mdlCV.candidateId = tblCV.getCandidate().getId();
        mdlCV.candidateUsername = tblCV.getCandidate().getUser().getUsername();

        mdlCV.award = new ArrayList<>();
        List<TblAward> tblAwardList = adwardRepository.findAllByCv(tblCV);
        for (TblAward tblAward : tblAwardList) {
            mdlCV.award.add(new MdlAward(tblAward));
        }

        mdlCV.certificate = new ArrayList<>();
        List<TblCertificate> tblCertificateList = certificateRepository.findAllByCv(tblCV);
        for (TblCertificate tblCertificate : tblCertificateList) {
            mdlCV.certificate.add(new MdlCertificate(tblCertificate));
        }

        mdlCV.education = new ArrayList<>();
        List<TblEducation> tblEducationList = educationRepository.findAllByCv(tblCV);
        for (TblEducation tblEducation : tblEducationList) {
            mdlCV.education.add(new MdlEducation(tblEducation));
        }

        mdlCV.exp = new ArrayList<>();
        List<TblExp> tblExpList = expRepository.findAllByCv(tblCV);
        for (TblExp tblExp : tblExpList) {
            mdlCV.exp.add(new MdlExp(tblExp));
        }

        mdlCV.participation = new ArrayList<>();
        List<TblParticipation> tblParticipationList = participationRepository.findAllByCv(tblCV);
        for (TblParticipation tblParticipation : tblParticipationList) {
            mdlCV.participation.add(new MdlParticipation(tblParticipation));
        }

        mdlCV.project = new ArrayList<>();
        List<TblProject> tblProjectList = projectRepository.findAllByCv(tblCV);
        for (TblProject tblProject : tblProjectList) {
            mdlCV.project.add(new MdlProject(tblProject));
        }

        mdlCV.specialize = new ArrayList<>();
        List<TblSpecialize> tblSpecializeList = specializeRepository.findAllByCv(tblCV);
        for (TblSpecialize tblSpecialize : tblSpecializeList) {
            mdlCV.specialize.add(new MdlSpecialize(tblSpecialize));
        }
        return mdlCV;
    }
}
