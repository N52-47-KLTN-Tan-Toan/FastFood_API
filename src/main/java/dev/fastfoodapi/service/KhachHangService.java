package dev.fastfoodapi.service;

import dev.fastfoodapi.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {

    KhachHang save(KhachHang obj);

    Optional<KhachHang> findById(UUID id);

    List<KhachHang> findAll();

    KhachHang update(UUID id, KhachHang obj);

    void delete(UUID id);

}
