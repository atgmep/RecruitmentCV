package study.recruit.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "tbl_company", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblCompany {

    private static final long serialVersionUID = 1L;
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Expose
    @Column(name = "name", length = 300)
    private String name;
    @Expose
    @Column(name = "address", length = 300)
    private String address;
    @Expose
    @Column(name = "phone", length = 45)
    private String phone;
    @Expose
    @Column(name = "email", length = 45)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Collection<TblDepartment> departmentCollection;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
