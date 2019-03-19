package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblParticipation;

public class MdlParticipation {
    @Expose
    Integer id;
    @Expose
    Integer cv;
    @Expose
    String time;
    @Expose
    Integer alphabetic;
    @Expose
    String activity;
    @Expose
    String description;


    public MdlParticipation(TblParticipation tblParticipation) {
        this.id = tblParticipation.getId();
        this.cv = tblParticipation.getCv().getId();
        this.time = tblParticipation.getTime();
        this.alphabetic = tblParticipation.getAlphabetic();
        this.activity = tblParticipation.getActivity();
        this.description = tblParticipation.getDescription();
    }
}
