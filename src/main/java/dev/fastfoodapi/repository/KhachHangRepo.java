package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KhachHangRepo extends JpaRepository<KhachHang, UUID> {

    @Query("SELECT kh FROM KhachHang kh WHERE kh.username = :s")
    KhachHang findByUsername(String s);

}
