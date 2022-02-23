package dev.fastfoodapi.service;

import dev.fastfoodapi.model.LoaiMatHang;
import dev.fastfoodapi.repository.LoaiMatHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiMatHangServiceImpl implements LoaiMatHangService{

    @Autowired
    private LoaiMatHangRepo loaiMatHangRepo;

    @Override
    public LoaiMatHang save(LoaiMatHang obj) {
        return loaiMatHangRepo.save(obj);
    }

    @Override
    public Optional<LoaiMatHang> findById(Long id) {
        return loaiMatHangRepo.findById(id);
    }

    @Override
    public List<LoaiMatHang> findAll() {
        return loaiMatHangRepo.findAll();
    }

    @Override
    public LoaiMatHang update(Long id, LoaiMatHang obj) {
        obj.setMaLMH(id);
        return loaiMatHangRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        loaiMatHangRepo.deleteById(id);
    }
}
