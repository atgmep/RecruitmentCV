package study.recruit.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_candidate", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblCandidate {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "fullName", length = 300)
    private String fullName;
    @Column(name = "objective", length = 300)
    private String objective;
    @Column(name = "dob")
    private Long dob;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "phone", length = 45)
    private String phone;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "address", length = 300)
    private String address;
    @Column(name = "website", length = 45)
    private String website;
    @OneToOne
    @JoinColumn(name = "tbl_user_id")
    private TblUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public TblUser getUser() {
        return user;
    }

    public void setUser(TblUser user) {
        this.user = user;
    }
}
