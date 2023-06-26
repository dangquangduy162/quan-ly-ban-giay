package com.example.demo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GioHangViewModel {
    private List<SanPhamTrongGio> sanPhamTrongGios = new ArrayList<SanPhamTrongGio>();

    public BigDecimal getTongTien() {
        return sanPhamTrongGios.stream()
                .map(sp -> sp.getThanhTien())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    public List<SanPhamTrongGio> getSanPhamTrongGios() {
        return sanPhamTrongGios;
    }

    public void setSanPhamTrongGios(List<SanPhamTrongGio> sanPhamTrongGios) {
        this.sanPhamTrongGios = sanPhamTrongGios;
    }
}


