package study.recruit.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "tbl_award", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblAward {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tbl_curriculum_vitae_id")
    private TblCV cv;
    @Column(name = "time", length = 45)
    private String time;
    @Column(name = "alphabetic")
    private Integer alphabetic;
    @Column(name = "name", length = 300)
    private String name;

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
}
