package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.MatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatHangRepo extends JpaRepository<MatHang, Long> {

    @Query("SELECT mh FROM MatHang mh WHERE mh.loaiMatHang.maLMH = :id")
    List<MatHang> findAllByLoaiMatHang(Long id);
}
