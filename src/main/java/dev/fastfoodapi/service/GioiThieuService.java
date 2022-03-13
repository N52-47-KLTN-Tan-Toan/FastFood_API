package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioiThieu;

import java.util.List;
import java.util.Optional;

public interface GioiThieuService {

    //Hàm CRUD mặc định
    GioiThieu save(GioiThieu obj);

    Optional<GioiThieu> findById(Long id);

    List<GioiThieu> findAll();

    GioiThieu update(Long id, GioiThieu obj);

    void delete(Long id);

}
