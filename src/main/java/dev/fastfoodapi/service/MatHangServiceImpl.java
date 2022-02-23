package dev.fastfoodapi.service;

import dev.fastfoodapi.model.MatHang;
import dev.fastfoodapi.repository.MatHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatHangServiceImpl implements MatHangService{

    @Autowired
    private MatHangRepo matHangRepo;

    @Override
    public MatHang save(MatHang obj) {
        return matHangRepo.save(obj);
    }

    @Override
    public Optional<MatHang> findById(Long id) {
        return matHangRepo.findById(id);
    }

    @Override
    public List<MatHang> findAll() {
        return matHangRepo.findAll();
    }

    @Override
    public MatHang update(Long id, MatHang obj) {
        obj.setMaMH(id);
        return matHangRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        matHangRepo.deleteById(id);
    }
}
