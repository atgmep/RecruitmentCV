package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblAward;

public class MdlAward {
    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String name;


    public MdlAward(TblAward tblAward) {
        this.id = tblAward.getId();
        this.cv = tblAward.getCv().getId();
        this.time = tblAward.getTime();
        this.alphabetic = tblAward.getAlphabetic();
        this.name = tblAward.getName();
    }
}
