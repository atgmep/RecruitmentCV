package study.recruit.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_project", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblProject {

    private static final long serialVersionUID = 1L;
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tbl_curriculum_vitae_id")
    private TblCV cv;
    @Expose
    @Column(name = "time", length = 45)
    private String time;
    @Column(name = "alphabetic")
    private Integer alphabetic;
    @Expose
    @Column(name = "name", length = 300)
    private String name;
    @Expose
    @Column(name = "group", length = 300)
    private String group;
    @Expose
    @Column(name = "description", length = 300)
    private String description;
    @Expose
    @Column(name = "teamSize", length = 300)
    private String teamSize;
    @Expose
    @Column(name = "position", length = 300)
    private String position;
    @Expose
    @Column(name = "responsibility", length = 300)
    private String responsibility;
    @Expose
    @Column(name = "technology", length = 300)
    private String technology;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblCV getCv() {
        return cv;
    }

    public void setCv(TblCV cv) {
        this.cv = cv;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(Integer alphabetic) {
        this.alphabetic = alphabetic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
