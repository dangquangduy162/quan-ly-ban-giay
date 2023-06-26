package com.example.demo.repository;

import com.example.demo.model.GioHangDomainModel;
import org.springframework.stereotype.Component;

@Component
public class GioHangSessionRepository implements IGioHangRepository{

    private GioHangDomainModel gioHang = new GioHangDomainModel();
    // thêm sản phẩm vào giỏ
    @Override
    public void themSanPhamVaoGio(Integer maGiay, Integer soLuong) {
        gioHang.getDsSanPhamTrongGio().put(maGiay, soLuong);
    }
    // cập nhật sản phẩm
    @Override
    public void capNhapSoLuongSanPhamTrongGio(Integer maGiay, Integer soLuong) {
        gioHang.getDsSanPhamTrongGio().put(maGiay, soLuong);
    }
    public GioHangDomainModel layGioHang() {
        return gioHang;
    }
    // xóa sản phẩm vào giỏ
    @Override
    public void xoaSanPhamTrongGio(Integer maGiay) {
        gioHang.getDsSanPhamTrongGio().remove(maGiay);
    }

    @Override
    public void xoaToanBoSanPhamTrongGio() {
        gioHang.getDsSanPhamTrongGio().clear();
    }
}
