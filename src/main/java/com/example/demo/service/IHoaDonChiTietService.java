package com.example.demo.service;

import com.example.demo.model.HoaDonChiTiet;

import java.util.List;

public interface IHoaDonChiTietService {
    void luuHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet);
    void luuDanhSachHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTietList);
}
