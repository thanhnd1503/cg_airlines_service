package com.airline.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotBlank
    @Column(name = "`desc`", length = 100, nullable = false)
    private String desc;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
}