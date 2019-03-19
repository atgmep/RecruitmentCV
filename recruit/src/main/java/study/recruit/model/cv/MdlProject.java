package study.recruit.model.cv;

import com.google.gson.annotations.Expose;
import study.recruit.entity.TblProject;

public class MdlProject {
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
    @Expose
    String group;
    @Expose
    String description;
    @Expose
    String teamSize;
    @Expose
    String position;
    @Expose
    String responsibility;
    @Expose
    String technology;

    public MdlProject(TblProject tblProject) {
        this.id = tblProject.getId();
        this.cv = tblProject.getCv().getId();
        this.time = tblProject.getTime();
        this.alphabetic = tblProject.getAlphabetic();
        this.name = tblProject.getName();
        this.group = tblProject.getGroup();
        this.description = tblProject.getDescription();
        this.teamSize = tblProject.getTeamSize();
        this.position = tblProject.getPosition();
        this.responsibility = tblProject.getResponsibility();
        this.technology = tblProject.getTechnology();
    }
}
