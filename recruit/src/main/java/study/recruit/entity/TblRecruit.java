package study.recruit.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "tbl_recruit", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblRecruit {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 300)
    private String name;
    @Column(name = "description", length = 3000)
    private String description;
    @Column(name = "minSalary")
    private Double minSalary;
    @Column(name = "maxSalary")
    private Double maxSalary;
    @Column(name = "applyFrom")
    private Long applyFrom;
    @Column(name = "applyTo")
    private Long applyTo;
    @ManyToOne
    @JoinColumn(name = "tbl_department_id")
    private TblDepartment department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recruit")
    private Collection<TblApply> applyCollection;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Long getApplyFrom() {
        return applyFrom;
    }

    public void setApplyFrom(Long applyFrom) {
        this.applyFrom = applyFrom;
    }

    public Long getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(Long applyTo) {
        this.applyTo = applyTo;
    }

    public TblDepartment getDepartment() {
        return department;
    }

    public void setDepartment(TblDepartment department) {
        this.department = department;
    }
}
