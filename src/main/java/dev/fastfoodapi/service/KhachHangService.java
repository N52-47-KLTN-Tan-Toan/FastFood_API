package dev.fastfoodapi.service;

import dev.fastfoodapi.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface KhachHangService {

    KhachHang save(KhachHang obj);

    Optional<KhachHang> findById(Long id);

    Page<KhachHang> findAll(Pageable pageable);

    KhachHang update(Long id, KhachHang obj);

    void delete(Long id);

}
