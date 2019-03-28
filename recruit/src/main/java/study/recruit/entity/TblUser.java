package study.recruit.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_user", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblUser  implements UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "username", length = 45)
    private String username;
    @Column(name = "password", length = 45)
    private String password;
    @Column(name = "role", length = 45)
    private String role;
    @Column(name = "status")
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private TblDepartment department;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private TblCandidate candidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TblDepartment getDepartment() {
        return department;
    }

    public void setDepartment(TblDepartment department) {
        this.department = department;
    }

    public TblCandidate getCandidate() {
        return candidate;
    }

    public void setCandidate(TblCandidate candidate) {
        this.candidate = candidate;
    }
}
