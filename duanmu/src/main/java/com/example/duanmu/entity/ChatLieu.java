package com.example.duanmu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_lieu")

@Getter
@Setter
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma", nullable = false, unique = true)
    private String ma;

    @Column(name = "ten", nullable = false)
    private String ten;

    @OneToMany(mappedBy = "chatLieu", fetch = FetchType.LAZY)
    private List<SanPham> sanPhams = new ArrayList<>();
}