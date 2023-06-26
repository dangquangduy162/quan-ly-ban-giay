package com.example.demo.controller;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.SanPham;
import com.example.demo.repository.IHoaDonChiTietRepository;
import com.example.demo.repository.IHoaDonRepository;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/assignment/hoa-don")
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;
    @RequestMapping
    public String viewHoaDon(Model model){
        List<HoaDon> hoaDonList = hoaDonService.findAll();
        model.addAttribute("hoaDonList", hoaDonList);
        return "hoa-don";
    }
    @GetMapping("/chi-tiet-san-pham")
    public String getChiTietSanPham(@RequestParam("idHoaDon") int idHoaDon, Model model) {
        List<HoaDonChiTiet> chiTietHoaDonList = hoaDonChiTietRepository.findByHoaDonIdHoaDon(idHoaDon);
        model.addAttribute("chiTietHoaDonList", chiTietHoaDonList);
        return "chi-tiet-san-pham";
    }

}
