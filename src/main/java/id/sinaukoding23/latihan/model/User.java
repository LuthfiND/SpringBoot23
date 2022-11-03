package id.sinaukoding23.latihan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column
    private String username;

    @Column
    private String profileName;

    @Column
    private String password;

    @Column
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}