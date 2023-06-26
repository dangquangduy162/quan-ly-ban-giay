package com.example.demo.controller;

import com.example.demo.model.SanPham;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.math.BigDecimal;

@Controller
@RequestMapping("/assignment/san-pham")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping
    public String view(Model model, @RequestParam(name = "tenGiay", required = false) String tenGiay, @RequestParam(defaultValue = "1") int page
            , @RequestParam(name = "mauSac", required = false) String mauSac) {
        Page<SanPham> pageSanPham;

        if (page < 1) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 5);
        if (tenGiay == null || tenGiay.isBlank()) {
            if (mauSac != null && !mauSac.isBlank()) {
                pageSanPham = sanPhamService.findByMauSacContains(mauSac, pageable);
            } else {
                pageSanPham = sanPhamService.findAll(pageable);
            }
        } else {
            pageSanPham = sanPhamService.findByTenGiayContains(tenGiay, pageable);
        }
        model.addAttribute("pageSanPham", pageSanPham);
        return "san-pham";
    }

    @GetMapping("/add")
    public String addSanPham() {
        return "add-san-pham";
    }

    @PostMapping("/add")
    public String addSanPham(@ModelAttribute("sanPham") SanPham sanPham, BindingResult bindingResult, Model model) {
        if (sanPham.getTenGiay() == null || sanPham.getTenGiay().isEmpty()) {
            bindingResult.rejectValue("tenGiay", "field.required", "Vui long dien day du thong tin");
        }

        if (sanPham.getGiaBan() == null || sanPham.getGiaBan().compareTo(BigDecimal.ZERO) <= 0) {
            bindingResult.rejectValue("giaBan", "field.invalid", "Gia ban phai lon hon 0");
        }
        if (sanPham.getSoLuong() == null || sanPham.getSoLuong() <= 0) {
            bindingResult.rejectValue("soLuong", "field.invalid", "So luong phai lon hon 0");
        }

        if (sanPham.getMauSac() == null || sanPham.getMauSac().isEmpty()) {
            bindingResult.rejectValue("mauSac", "field.required", "Vui long dien day du thong tin");
        }
        if (sanPham.getChatLieu() == null || sanPham.getChatLieu().isEmpty()) {
            bindingResult.rejectValue("chatLieu", "field.required", "Vui long dien day du thong tin");
        }
        if (sanPham.getMoTa() == null || sanPham.getMoTa().isEmpty()) {
            bindingResult.rejectValue("moTa", "field.required", "Vui long dien day du thong tin");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "add-san-pham";
        }

        sanPhamService.addSanPham(sanPham);
        return "redirect:/assignment/san-pham";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        sanPhamService.deleteById(id);
        return "redirect:/assignment/san-pham";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("sanPham", sanPham);
        return "update-san-pham";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("sanPham") SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/assignment/san-pham";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model) {
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("sanPham", sanPham);
        return "detail-san-pham";
    }
}
