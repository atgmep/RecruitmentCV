package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblSpecialize;

public class MdlSpecialize {

    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String job;

    public MdlSpecialize(TblSpecialize tblSpecialize) {
        this.id = tblSpecialize.getId();
        this.cv = tblSpecialize.getCv().getId();
        this.time = tblSpecialize.getTime();
        this.alphabetic = tblSpecialize.getAlphabetic();
        this.job = tblSpecialize.getJob();
    }
}
