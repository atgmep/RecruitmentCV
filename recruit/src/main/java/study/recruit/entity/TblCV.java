package study.recruit.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "tbl_curriculum_vitae", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblCV {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 300)
    private String name;
    @Column(name = "objective", length = 3000)
    private String objective;
    @Column(name = "additionalInfo", length = 300)
    private String additionalInfo;
    @Column(name = "pdfUrl", length = 100)
    private String pdfUrl;
    @ManyToOne
    @JoinColumn(name = "tbl_candidate_id")
    private TblCandidate candidate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblApply> applyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblCertificate> certificateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblAward> awardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblExp> expCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblProject> projectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblEducation> educationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblParticipation> participationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblSpecialize> specializeCollection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public TblCandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(TblCandidate candidate) {
        this.candidate = candidate;
    }
}
