package com.blog.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
    name= "tbl_users"
)

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;

    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL

    )
    private List<PostEntity> posts = new ArrayList<>();
    @OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL

    )
    private List<CommentEntity> comments = new ArrayList<>();

}
