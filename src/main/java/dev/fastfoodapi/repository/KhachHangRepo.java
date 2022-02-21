package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {
}
