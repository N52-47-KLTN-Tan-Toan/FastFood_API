package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GioHangRepo extends JpaRepository<GioHang, Long> {

    @Query("SELECT gh FROM GioHang gh WHERE gh.khachHang.userId = :userId AND gh.matHang.maMH = :maMH")
    GioHang findByKhachHangAndMatHang(UUID userId, Long maMH);

    @Query("SELECT gh FROM GioHang gh WHERE gh.khachHang.userId = :userId")
    List<GioHang> findByKhachHang(UUID userId);

}
