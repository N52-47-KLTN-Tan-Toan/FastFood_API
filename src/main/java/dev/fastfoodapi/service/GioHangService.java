package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GioHangService {

    //Hàm CRUD mặc định
    GioHang save(GioHang obj);

    Optional<GioHang> findById(Long id);

    List<GioHang> findAll();

    GioHang update(Long id, GioHang obj);

    void delete(Long id);

    //Một số hàm khác
    boolean findByKhachHangAndMatHang(UUID userId, Long maMH);
}
