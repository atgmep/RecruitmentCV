package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblExp;

public class MdlExp {
    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String company;
    @Expose
    String position;

    public MdlExp(TblExp tblExp) {
        this.id = tblExp.getId();
        this.cv = tblExp.getCv().getId();
        this.time = tblExp.getTime();
        this.alphabetic = tblExp.getAlphabetic();
        this.company = tblExp.getCompany();
        this.position = tblExp.getPosition();
    }
}
