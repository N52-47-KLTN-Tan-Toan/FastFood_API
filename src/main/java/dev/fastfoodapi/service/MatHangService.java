package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioHang;
import dev.fastfoodapi.model.MatHang;

import java.util.List;
import java.util.Optional;

public interface MatHangService {

    MatHang save(MatHang obj);

    Optional<MatHang> findById(Long id);

    List<MatHang> findAll();

    MatHang update(Long id, MatHang obj);

    void delete(Long id);
}
