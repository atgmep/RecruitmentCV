package study.recruit.entity;

import com.google.gson.annotations.Expose;

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
    @Expose
    @Column(name = "name", length = 300)
    private String name;
    @Expose
    @Column(name = "objective", length = 3000)
    private String objective;
    @Expose
    @Column(name = "additionalInfo", length = 300)
    private String additionalInfo;
    @Expose
    @Column(name = "pdfUrl", length = 100)
    private String pdfUrl;
    @ManyToOne
    @JoinColumn(name = "tbl_candidate_id")
    private TblCandidate candidate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv")
    private Collection<TblApply> applyCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblCertificate> certificateCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblAward> awardCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblExp> expCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblProject> projectCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblEducation> educationCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
    private Collection<TblParticipation> participationCollection;
    @Expose
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cv", fetch = FetchType.EAGER)
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

    public Collection<TblCertificate> getCertificateCollection() {
        return certificateCollection;
    }

    public Collection<TblAward> getAwardCollection() {
        return awardCollection;
    }

    public Collection<TblExp> getExpCollection() {
        return expCollection;
    }

    public Collection<TblProject> getProjectCollection() {
        return projectCollection;
    }

    public Collection<TblEducation> getEducationCollection() {
        return educationCollection;
    }

    public Collection<TblParticipation> getParticipationCollection() {
        return participationCollection;
    }

    public Collection<TblSpecialize> getSpecializeCollection() {
        return specializeCollection;
    }
}
