package com.example.demo.service;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.IHoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HoaDonChiTietService implements IHoaDonChiTietService {
    @Autowired
    private IHoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public void luuHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void luuDanhSachHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTietList) {
        hoaDonChiTietRepository.saveAll(hoaDonChiTietList);
    }

}
