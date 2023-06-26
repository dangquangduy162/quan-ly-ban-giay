package com.example.demo.controller;

import com.example.demo.model.ThongKeSanPham;
import com.example.demo.service.ThongKeSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/assignment/thong-ke")
public class ThongKeSanPhamController {
    @Autowired
    private ThongKeSanPhamService thongKeSanPhamService;

    @GetMapping("/top10sanpham")
    public String getTop10SanPhamBanChay(Model model) {
        List<ThongKeSanPham> top10SanPham = thongKeSanPhamService.getTop10SanPhamBanChay();
        model.addAttribute("top10SanPham", top10SanPham);
        return "thong-ke";
    }
}
