package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.DonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DonDatHangRepo extends JpaRepository<DonDatHang, Long> {

    @Query("SELECT ddh FROM DonDatHang ddh WHERE ddh.khachHang.userId = :userId")
    List<DonDatHang> findAllByKhachHang(UUID userId);

}
