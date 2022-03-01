package dev.fastfoodapi.service;

import dev.fastfoodapi.model.MatHang;

import java.util.List;
import java.util.Optional;

public interface MatHangService {

    //Hàm CRUD mặc định
    MatHang save(MatHang obj);

    Optional<MatHang> findById(Long id);

    List<MatHang> findAll();

    MatHang update(Long id, MatHang obj);

    void delete(Long id);

    //Một số hàm khác được thêm vào
    List<MatHang> findAllByLMH(Long id);
}
