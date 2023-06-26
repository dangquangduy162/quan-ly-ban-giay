package com.example.demo.service;

import com.example.demo.model.GioHangDomainModel;
import com.example.demo.model.GioHangViewModel;

import com.example.demo.model.SanPham;
import com.example.demo.model.SanPhamTrongGio;
import com.example.demo.repository.GioHangSessionRepository;
import com.example.demo.repository.ISanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GioHangService {

    @Autowired
    private GioHangSessionRepository gioHangSessionRepository;
    @Autowired
    private ISanPhamRepository iSanPhamRepository;
    @Autowired
    private SanPhamService sanPhamService;

    // thêm sản phầm vào giỏ hàng

    public void themSanPhamVaoGio(Integer maGiay, Integer soLuongThem) {
        gioHangSessionRepository.themSanPhamVaoGio(maGiay, soLuongThem);
    }

    // Bỏ sản phẩm ra khỏi giỏ hàng

    public void boSanPhamKhoiGio(Integer maGiay) {
        gioHangSessionRepository.xoaSanPhamTrongGio(maGiay);
    }
    public void capNhatSoLuongHangTrongKho(List<SanPhamTrongGio> sanPhamTrongGios) {
        sanPhamService.capNhatSoLuongHangTrongKho(sanPhamTrongGios);
    }
    //xem sản phẩm trong giỏ

    public void xoaToanBoSanPhamTrongGio() {
        gioHangSessionRepository.xoaToanBoSanPhamTrongGio();
    }
    public GioHangViewModel xemSanPhamTrongGio() {
        GioHangViewModel gioHangViewModel = new GioHangViewModel();
        List<SanPhamTrongGio> sanPhamTrongGios = new ArrayList<>();
        GioHangDomainModel gioHangDomainModel = gioHangSessionRepository.layGioHang();
        for(Map.Entry<Integer, Integer> entry :
                gioHangDomainModel.getDsSanPhamTrongGio().entrySet()) {
            Integer maGiay = entry.getKey();
            Integer soLuong = entry.getValue();

            SanPham sanPham = iSanPhamRepository.findById(maGiay).get();

            SanPhamTrongGio sanPhamTrongGio = new SanPhamTrongGio();
            sanPhamTrongGio.setMaGiay(maGiay);
            sanPhamTrongGio.setTenGiay(sanPham.getTenGiay());
            sanPhamTrongGio.setSoLuong(soLuong);
            sanPhamTrongGio.setGiaBan(sanPham.getGiaBan());

            sanPhamTrongGios.add(sanPhamTrongGio);
        }

        gioHangViewModel.setSanPhamTrongGios(sanPhamTrongGios);
        return gioHangViewModel;
    }


}
