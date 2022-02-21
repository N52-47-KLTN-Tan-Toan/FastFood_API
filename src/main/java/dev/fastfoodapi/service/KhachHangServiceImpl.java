package dev.fastfoodapi.service;

import dev.fastfoodapi.model.KhachHang;
import dev.fastfoodapi.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService{

    @Autowired
    private KhachHangRepo khachHangRepo;

    @Override
    public KhachHang save(KhachHang obj) {
        return khachHangRepo.save(obj);
    }

    @Override
    public Optional<KhachHang> findById(Long id) {
        return khachHangRepo.findById(id);
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepo.findAll(pageable);
    }

    @Override
    public KhachHang update(Long id, KhachHang obj) {
        obj.setUserId(id);
        return khachHangRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        khachHangRepo.deleteById(id);
    }
}
