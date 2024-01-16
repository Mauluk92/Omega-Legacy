package it.aleph.omega.model.security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="group_identity")
@Getter
@Setter
public class GroupIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, name="id")
    private Long id;
    @Column(nullable = false, name="name")
    private String name;
}
