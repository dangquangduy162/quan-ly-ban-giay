package com.example.demo.service;

import com.example.demo.model.HoaDon;
import com.example.demo.model.SanPham;
import com.example.demo.repository.IHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HoaDonService implements IHoaDonService {
    @Autowired
    private IHoaDonRepository hoaDonRepository;

    @Override
    public void luuHoaDon(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public List<HoaDon> findAll() {
        ;
        return hoaDonRepository.findAll();
    }


}
