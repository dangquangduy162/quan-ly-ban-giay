package com.example.demo.repository;

import com.example.demo.model.HoaDonChiTiet;

import com.example.demo.model.ThongKeSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    @Query("SELECT new com.example.demo.model.ThongKeSanPham(h.maGiay, h.tenGiay, SUM(h.soLuong)) " +
            "FROM HoaDonChiTiet h " +
            "GROUP BY h.maGiay, h.tenGiay " +
            "ORDER BY SUM(h.soLuong) DESC")
    List<ThongKeSanPham> getTop10SanPhamBanChayNhat();
    List<HoaDonChiTiet> findByHoaDonIdHoaDon(int idHoaDon);
}
