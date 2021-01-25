package com.satori.giftlist.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @Nullable
    @Column(name="id")
    private Integer id;

    @NonNull
    @Column(name="name")
    private String name;

    @NonNull
    @Column(name="password")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
