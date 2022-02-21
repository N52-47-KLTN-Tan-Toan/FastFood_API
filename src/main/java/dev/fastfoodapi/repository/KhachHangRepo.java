package dev.fastfoodapi.repository;

import dev.fastfoodapi.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangRepo extends JpaRepository<KhachHang, UUID> {
}
