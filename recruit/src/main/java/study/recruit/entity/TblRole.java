package study.recruit.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;


@Entity
@Table(name = "tbl_role", catalog = "recruitdb", schema = "recruitdb")
@XmlRootElement
public class TblRole {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<TblUser> userCollection;

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
}
