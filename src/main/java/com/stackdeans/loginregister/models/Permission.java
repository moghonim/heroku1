package com.stackdeans.loginregister.models;

import javax.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EPermission name;
//    @Column
//    private String permissionType;

    public Permission() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EPermission getName() {
        return name;
    }

    public void setName(EPermission name) {
        this.name = name;
    }
}
