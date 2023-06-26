package com.example.demo.repository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHoaDonRepository extends JpaRepository<HoaDon, Integer> {


    List<SanPham> findByIdHoaDon(int idHoaDon);

}
