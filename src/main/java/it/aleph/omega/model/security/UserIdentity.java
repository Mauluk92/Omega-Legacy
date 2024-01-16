package it.aleph.omega.model.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_identity")
@Getter
@Setter
public class UserIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, name="id")
    private Long id;
    @Column(nullable = false, name="username")
    private String username;
    @Column(nullable = false, name="password")
    private String password;
    @Column(nullable = false, name="status")
    private Boolean status;

    @OneToOne(cascade={CascadeType.MERGE, CascadeType.MERGE})
    @JoinColumn(name="group")
    private GroupIdentity group;
}
