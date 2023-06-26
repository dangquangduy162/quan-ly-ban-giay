package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sanpham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magiay")
    private int maGiay;
    @Column(name = "tengiay")
    private String tenGiay;
    @Column(name = "giaban")
    private BigDecimal giaBan;
    @Column(name = "soluong")
    private Integer soLuong;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "mausac")
    private String mauSac;
    @Column(name = "chatlieu")
    private String chatLieu;


}
