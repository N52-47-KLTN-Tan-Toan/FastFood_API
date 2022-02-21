package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioHang;
import dev.fastfoodapi.repository.GioHangRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService{

    @Autowired
    private GioHangRepo gioHangRepo;

    @Override
    public GioHang save(GioHang obj) {
        return gioHangRepo.save(obj);
    }

    @Override
    public Optional<GioHang> findById(Long id) {
        return gioHangRepo.findById(id);
    }

    @Override
    public List<GioHang> findAll() {
        return gioHangRepo.findAll();
    }

    @Override
    public GioHang update(Long id, GioHang obj) {
        obj.setMaGH(id);
        return gioHangRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        gioHangRepo.deleteById(id);
    }
}
