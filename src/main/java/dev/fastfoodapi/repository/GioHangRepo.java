package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangRepo extends JpaRepository<GioHang, Long> {
}
