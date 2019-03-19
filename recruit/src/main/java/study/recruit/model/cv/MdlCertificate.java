package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblCertificate;

public class MdlCertificate {

    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String certificate;


    public MdlCertificate(TblCertificate tblCertificate) {
        this.id = tblCertificate.getId();
        this.cv = tblCertificate.getCv().getId();
        this.time = tblCertificate.getTime();
        this.alphabetic = tblCertificate.getAlphabetic();
        this.certificate = tblCertificate.getCertificate();
    }
}
