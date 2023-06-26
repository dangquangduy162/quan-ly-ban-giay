package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class GioHangDomainModel {
    private Map<Integer, Integer> dsSanPhamTrongGio = new HashMap<>();

    public Map<Integer, Integer> getDsSanPhamTrongGio() {
        return dsSanPhamTrongGio;
    }

    public void setDsSanPhamTrongGio(Map<Integer, Integer> dsSanPhamTrongGio) {
        this.dsSanPhamTrongGio = dsSanPhamTrongGio;
    }
}
