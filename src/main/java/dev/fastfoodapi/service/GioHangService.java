package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioHang;

import java.util.List;
import java.util.Optional;

public interface GioHangService {

    GioHang save(GioHang obj);

    Optional<GioHang> findById(Long id);

    List<GioHang> findAll();

    GioHang update(Long id, GioHang obj);

    void delete(Long id);

}
