package com.example.duanmu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loai_san_pham")
@Getter
@Setter
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ma;

    @Column(name = "ten")
    private String ten;

    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> sanPhams = new ArrayList<>();


    public List<SanPham> getSanPhams() { return sanPhams; }
    public void setSanPhams(List<SanPham> sanPhams) { this.sanPhams = sanPhams; }
}