package study.recruit.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "tbl_department", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblDepartment {

    private static final long serialVersionUID = 1L;
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Expose
    @Column(name = "name", length = 300)
    private String name;
    @OneToOne
    @JoinColumn(name = "tbl_user_id")
    private TblUser user;
    @Expose
    @ManyToOne
    @JoinColumn(name = "tbl_company_id")
    private TblCompany company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<TblRecruit> recruitCollection;

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

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }

    public TblCompany getCompany() {
        return company;
    }

    public void setCompany(TblCompany company) {
        this.company = company;
    }
}
