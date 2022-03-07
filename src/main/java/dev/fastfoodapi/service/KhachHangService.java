package dev.fastfoodapi.service;

import dev.fastfoodapi.model.KhachHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {

    //Hàm CRUD mặc định
    KhachHang save(KhachHang obj);

    Optional<KhachHang> findById(UUID id);

    List<KhachHang> findAll();

    KhachHang update(UUID id, KhachHang obj);

    void delete(UUID id);

    //Một số hàm khác
    KhachHang findByPhone(String s);
}
