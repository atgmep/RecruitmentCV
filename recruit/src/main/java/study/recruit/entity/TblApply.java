package study.recruit.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_apply", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblApply {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tbl_recruit_id")
    private TblRecruit recruit;
    @ManyToOne
    @JoinColumn(name = "tbl_curriculum_vitae_id")
    private TblCV cv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TblRecruit getRecruit() {
        return recruit;
    }

    public void setRecruit(TblRecruit recruit) {
        this.recruit = recruit;
    }

    public TblCV getCv() {
        return cv;
    }

    public void setCv(TblCV cv) {
        this.cv = cv;
    }
}
