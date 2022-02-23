package dev.fastfoodapi.service;

import dev.fastfoodapi.model.DonDatHang;

import java.util.List;
import java.util.Optional;

public interface DonDatHangService {

    DonDatHang save(DonDatHang obj);

    Optional<DonDatHang> findById(Long id);

    List<DonDatHang> findAll();

    DonDatHang update(Long id, DonDatHang obj);

    void delete(Long id);

}
