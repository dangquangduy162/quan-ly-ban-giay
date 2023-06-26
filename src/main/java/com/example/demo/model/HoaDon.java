package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhoadon")
    private int idHoaDon;
    @Column(name = "ngaytao")
    private LocalDateTime ngayTao;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "tongtien")
    private BigDecimal tongTien;



    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon(int orderId, LocalDateTime ngayTao, String soDienThoai, BigDecimal tongTien) {
        this.idHoaDon = orderId;
        this.ngayTao = ngayTao;
        this.soDienThoai = soDienThoai;
        this.tongTien = tongTien;
    }

    public HoaDon() {
    }
}
