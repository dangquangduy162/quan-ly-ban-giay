package com.example.demo.service;

import com.example.demo.model.SanPham;
import com.example.demo.model.SanPhamTrongGio;
import com.example.demo.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SanPhamService implements ISanPhamService{

    @Autowired
    private ISanPhamRepository sanPhamRepository;

    @Override
    public Page<SanPham> findByTenGiayContains(String tenGiay, Pageable pageable) {
        return sanPhamRepository.findByTenGiayContains(tenGiay, pageable);
    }

    @Override
    public Page<SanPham> findAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }



    @Override
    public Page<SanPham> findByMauSacContains(String mauSac, Pageable pageable) {
        return sanPhamRepository.findByMauSacContains(mauSac, pageable);
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteById(int id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham findById(int id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public void save(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void capNhatSoLuongHangTrongKho(List<SanPhamTrongGio> sanPhamTrongGios) {
        for (SanPhamTrongGio sanPhamTrongGio : sanPhamTrongGios) {
            SanPham sanPham = sanPhamRepository.findById(sanPhamTrongGio.getMaGiay()).orElse(null);
            if (sanPham != null) {
                int soLuongMua = sanPhamTrongGio.getSoLuong();
                int soLuongHienTai = sanPham.getSoLuong();
                int soLuongConLai = soLuongHienTai - soLuongMua;
                sanPham.setSoLuong(soLuongConLai);
                sanPhamRepository.save(sanPham);
            }
        }
    }
}
