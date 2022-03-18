package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.MatHang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatHangRepo extends JpaRepository<MatHang, Long> {

    @Query("SELECT mh FROM MatHang mh WHERE mh.loaiMatHang.maLMH = :id")
    List<MatHang> findAllByLoaiMatHang(Long id);

    @Query("SELECT mh FROM MatHang mh WHERE mh.tenMH LIKE %?1%")
    List<MatHang> search(String keyword);

    @Query("SELECT mh FROM MatHang mh WHERE mh.moTa LIKE '%phô%'")
    List<MatHang> features();

    @Query("SELECT DISTINCT mh FROM MatHang mh JOIN ChiTietDonDatHang ct ON ct.matHang.maMH = mh.maMH" +
            " WHERE EXISTS (SELECT ct.matHang.maMH FROM ChiTietDonDatHang WHERE matHang.maMH = ct.matHang.maMH)" +
            " ORDER BY ct.maCTDDH")
    List<MatHang> topSeller();
}
