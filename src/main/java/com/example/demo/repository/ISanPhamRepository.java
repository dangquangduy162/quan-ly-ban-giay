package com.example.demo.repository;

import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
    Page<SanPham> findByTenGiayContains(String tenGiay, Pageable pageable);

    Page<SanPham> findByMauSacContains(String mauSac, Pageable pageable);
    void deleteById(int id);
    SanPham findById(int id);


}
