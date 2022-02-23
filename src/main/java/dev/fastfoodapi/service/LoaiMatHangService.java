package dev.fastfoodapi.service;

import dev.fastfoodapi.model.LoaiMatHang;

import java.util.List;
import java.util.Optional;

public interface LoaiMatHangService {

    LoaiMatHang save(LoaiMatHang obj);

    Optional<LoaiMatHang> findById(Long id);

    List<LoaiMatHang> findAll();

    LoaiMatHang update(Long id, LoaiMatHang obj);

    void delete(Long id);

}
