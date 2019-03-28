package study.recruit.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_specialize", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblSpecialize {


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
    @Column(name = "job", length = 300)
    private String job;

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
