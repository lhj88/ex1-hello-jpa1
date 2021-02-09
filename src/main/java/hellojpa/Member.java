package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {


    @Id
    private Long id;

    @Column(name = "name", nullable = false, length = 10, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member() {

    }



}