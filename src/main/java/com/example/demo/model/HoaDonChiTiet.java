package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhoadonchitiet")
    private Integer idHoaDon;
    @ManyToOne
    @JoinColumn(name = "idhoadon")
    private HoaDon hoaDon;
    @Column(name = "magiay")
    private int maGiay;
    @Column(name = "tengiay")
    private String  tenGiay;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "giaban")
    private BigDecimal giaBan;

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(int maGiay) {
        this.maGiay = maGiay;
    }

    public HoaDonChiTiet(Integer idHoaDon, HoaDon hoaDon, int maGiay, int soLuong, BigDecimal giaBan) {
        this.idHoaDon = idHoaDon;
        this.hoaDon = hoaDon;
        this.maGiay = maGiay;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public HoaDonChiTiet() {
    }
}
