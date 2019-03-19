package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblEducation;

public class MdlEducation {
    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String shool;
    @Expose
    String major;
    @Expose
    Double mark;

    public MdlEducation(TblEducation tblEducation) {
        this.id = tblEducation.getId();
        this.cv = tblEducation.getCv().getId();
        this.time = tblEducation.getTime();
        this.alphabetic = tblEducation.getAlphabetic();
        this.shool = tblEducation.getShool();
        this.major = tblEducation.getMajor();
        this.mark = tblEducation.getMark();
    }
}
