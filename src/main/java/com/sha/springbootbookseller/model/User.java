package com.sha.springbootbookseller.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author sa
 * @date 3.07.2021
 * @time 16:53
 */
@Data
@Entity
@Table(name = "users") //don't use user because user is reserved name on PostgreSQL.
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    @NotNull(message = "username shouldn't be null")
    @NotBlank
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    @NotNull(message = "password shouldn't be null")
    @NotBlank
    private String password;

    @Column(name = "name", nullable = false, length = 100)
    @NotNull(message = "name shouldn't be null")
    @NotBlank
    private String name;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient
    private String token;
    
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = true
    )
    @JoinColumn(
            name = "file_id",
            referencedColumnName = "id"
    )
    private FileDb filedb;
    

    



}
