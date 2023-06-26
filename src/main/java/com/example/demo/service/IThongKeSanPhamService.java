package com.example.demo.service;

import com.example.demo.model.ThongKeSanPham;

import java.util.List;

public interface IThongKeSanPhamService {
    List<ThongKeSanPham> getTop10SanPhamBanChay();
    List<ThongKeSanPham> getTop10SanPhamBanChayTheoThang(int month);
    List<ThongKeSanPham> getTop10SanPhamBanChayTheoTuan(int week);
    List<ThongKeSanPham> getTop10SanPhamBanChayTheoNam(int year);
}
