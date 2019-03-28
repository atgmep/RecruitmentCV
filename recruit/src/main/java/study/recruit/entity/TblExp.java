package study.recruit.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_exp", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblExp {

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
    @Column(name = "company", length = 300)
    private String company;
    @Expose
    @Column(name = "position", length = 300)
    private String position;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
