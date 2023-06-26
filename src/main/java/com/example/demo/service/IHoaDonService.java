package com.example.demo.service;

import com.example.demo.model.HoaDon;
import com.example.demo.model.SanPham;

import java.util.List;

public interface IHoaDonService {
    void luuHoaDon(HoaDon hoaDon);
    List<HoaDon> findAll();

}
