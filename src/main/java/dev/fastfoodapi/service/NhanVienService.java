package dev.fastfoodapi.service;

import dev.fastfoodapi.model.NhanVien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {

    //Hàm CRUD mặc định
    NhanVien save(NhanVien obj);

    Optional<NhanVien> findById(UUID id);

    List<NhanVien> findAll();

    NhanVien update(UUID id, NhanVien obj);

    void delete(UUID id);

    //Một số hàm khác
    NhanVien findByUsername(String s);

    String findRoleNameByUsername(String s);

}
