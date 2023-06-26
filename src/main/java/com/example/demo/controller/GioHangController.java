package com.example.demo.controller;

import com.example.demo.model.GioHangViewModel;
import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.SanPhamTrongGio;
import com.example.demo.service.GioHangService;
import com.example.demo.service.HoaDonChiTietService;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/assignment/gio-hang")
public class GioHangController {
    @Autowired
    private GioHangService gioHangService;
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @GetMapping
    public String viewGioHang(Model model) {
        GioHangViewModel gioHangViewModel = gioHangService.xemSanPhamTrongGio();
        model.addAttribute("gioHangViewModel", gioHangViewModel);
        return "gio-hang";
    }

    @PostMapping("/them-san-pham")
    public String themSanPhamVaoGioHang(Model model, @RequestParam("maGiay") int maGiay, @RequestParam(value = "soLuongThem") Integer soLuongThem) {

        gioHangService.themSanPhamVaoGio(maGiay, soLuongThem);
        GioHangViewModel gioHangViewModel = gioHangService.xemSanPhamTrongGio();
        model.addAttribute("gioHangViewModel", gioHangViewModel);
        return "redirect:/assignment/gio-hang";
    }

    @PostMapping("/bo-san-pham")
    public String boSanPhamKhoiGio(@RequestParam("maGiay") int maGiay) {
        gioHangService.boSanPhamKhoiGio(maGiay);
        return "redirect:/assignment/gio-hang";
    }
    @PostMapping("/xoa-toan-bo-san-pham")
    public String xoaToanBoSanPhamTrongGio() {
        gioHangService.xoaToanBoSanPhamTrongGio();
        return "redirect:/assignment/gio-hang";
    }
    @PostMapping("/mua-hang")
    public String muaHang(Model model, @RequestParam("soDienThoai") String soDienThoai) {
        GioHangViewModel gioHangViewModel = gioHangService.xemSanPhamTrongGio();
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNgayTao(LocalDateTime.now());
        hoaDon.setTongTien(gioHangViewModel.getTongTien());
        hoaDon.setSoDienThoai(soDienThoai);

        hoaDonService.luuHoaDon(hoaDon);
        gioHangService.capNhatSoLuongHangTrongKho(gioHangViewModel.getSanPhamTrongGios());

        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        for(SanPhamTrongGio sanPhamTrongGio: gioHangViewModel.getSanPhamTrongGios()){
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setMaGiay(sanPhamTrongGio.getMaGiay());
            hoaDonChiTiet.setSoLuong(sanPhamTrongGio.getSoLuong());
            hoaDonChiTiet.setGiaBan(sanPhamTrongGio.getGiaBan());
            hoaDonChiTiet.setTenGiay(sanPhamTrongGio.getTenGiay());
            hoaDonChiTietList.add(hoaDonChiTiet);
        }
        hoaDonChiTietService.luuDanhSachHoaDonChiTiet(hoaDonChiTietList);

        // Gửi thông tin hóa đơn đến view
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("hoaDonChiTietList", hoaDonChiTietList);

        model.addAttribute("hoaDon", hoaDon);
        return "thong-tin-hoa-don";

    }
    @GetMapping("/thong-tin-hoa-don")
    public String viewThongTinHoaDon(Model model) {
        return "thong-tin-hoa-don";
    }


}
