package com.example.demo.model;

import java.math.BigDecimal;

public class SanPhamTrongGio {
    private Integer maGiay;
    private String tenGiay;
    private BigDecimal giaBan;
    private Integer soLuong;
    private BigDecimal thanhTien;
    private SanPham sanPham;

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public BigDecimal getThanhTien() {
        return giaBan.multiply(BigDecimal.valueOf(soLuong));
    }

    public SanPhamTrongGio() {
    }

    public SanPhamTrongGio(Integer maGiay, String tenGiay, BigDecimal giaBan, Integer soLuong, BigDecimal thanhTien, SanPham sanPham) {
        this.maGiay = maGiay;
        this.tenGiay = tenGiay;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.sanPham = sanPham;
    }

    public Integer getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(Integer maGiay) {
        this.maGiay = maGiay;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
