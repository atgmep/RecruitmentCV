package study.recruit.model.cv;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MdlCV {

    @Expose
    Integer id;
    @Expose
    String name;
    @Expose
    String objective;
    @Expose
    String additionalInfo;
    @Expose
    String pdfUrl;
    @Expose
    Integer candidateId;
    @Expose
    String candidateUsername;
    @Expose
    List<MdlAward> award;
    @Expose
    List<MdlCertificate> certificate;
    @Expose
    List<MdlEducation> education;
    @Expose
    List<MdlExp> exp;
    @Expose
    List<MdlParticipation> participation;
    @Expose
    List<MdlProject> project;
    @Expose
    List<MdlSpecialize> specialize;


}
