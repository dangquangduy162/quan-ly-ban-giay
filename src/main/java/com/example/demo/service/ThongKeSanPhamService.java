package com.example.demo.service;

import com.example.demo.model.ThongKeSanPham;
import com.example.demo.repository.IHoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThongKeSanPhamService implements IThongKeSanPhamService{
    @Autowired
    IHoaDonChiTietRepository hoaDonChiTietRepository;
    @Override
    public List<ThongKeSanPham> getTop10SanPhamBanChay() {
        return hoaDonChiTietRepository.getTop10SanPhamBanChayNhat();
    }

    @Override
    public List<ThongKeSanPham> getTop10SanPhamBanChayTheoThang(int month) {
        return null;
    }

    @Override
    public List<ThongKeSanPham> getTop10SanPhamBanChayTheoTuan(int week) {
        return null;
    }

    @Override
    public List<ThongKeSanPham> getTop10SanPhamBanChayTheoNam(int year) {
        return null;
    }
}
