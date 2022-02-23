package dev.fastfoodapi.service;

import dev.fastfoodapi.model.KhachHang;
import dev.fastfoodapi.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService{

    @Autowired
    private KhachHangRepo khachHangRepo;

    @Override
    public KhachHang save(KhachHang obj) {
        return khachHangRepo.save(obj);
    }

    @Override
    public Optional<KhachHang> findById(UUID id) {
        return khachHangRepo.findById(id);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public KhachHang update(UUID id, KhachHang obj) {
        obj.setUserId(id);
        return khachHangRepo.save(obj);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepo.deleteById(id);
    }
}
