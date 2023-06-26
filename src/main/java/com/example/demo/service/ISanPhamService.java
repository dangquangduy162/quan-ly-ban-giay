package com.example.demo.service;

import com.example.demo.model.SanPham;
import com.example.demo.model.SanPhamTrongGio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ISanPhamService {
    Page<SanPham> findByTenGiayContains(String tenGiay, Pageable pageable);
    Page<SanPham> findAll(Pageable pageable);

    Page<SanPham> findByMauSacContains(String mauSac, Pageable pageable);
    void addSanPham(SanPham sanPham);
    void deleteById(int id);
    SanPham findById(int id);
    void save(SanPham sanPham);
    void capNhatSoLuongHangTrongKho(List<SanPhamTrongGio> sanPhamTrongGios);
}
