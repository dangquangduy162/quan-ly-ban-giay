package com.example.demo.repository;

import com.example.demo.model.GioHangViewModel;
import com.example.demo.model.SanPhamTrongGio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGioHangRepository {
    void themSanPhamVaoGio(Integer maGiay, Integer soLuong);

    void capNhapSoLuongSanPhamTrongGio(Integer maGiay, Integer soLuong);

    void xoaSanPhamTrongGio(Integer maGiay);
    void xoaToanBoSanPhamTrongGio();

}
