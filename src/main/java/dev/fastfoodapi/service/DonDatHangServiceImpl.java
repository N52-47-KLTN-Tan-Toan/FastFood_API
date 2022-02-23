package dev.fastfoodapi.service;

import dev.fastfoodapi.model.DonDatHang;
import dev.fastfoodapi.repository.DonDatHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonDatHangServiceImpl implements DonDatHangService{

    @Autowired
    private DonDatHangRepo donDatHangRepo;

    @Override
    public DonDatHang save(DonDatHang obj) {
        return donDatHangRepo.save(obj);
    }

    @Override
    public Optional<DonDatHang> findById(Long id) {
        return donDatHangRepo.findById(id);
    }

    @Override
    public List<DonDatHang> findAll() {
        return donDatHangRepo.findAll();
    }

    @Override
    public DonDatHang update(Long id, DonDatHang obj) {
        obj.setMaDDH(id);
        return donDatHangRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        donDatHangRepo.deleteById(id);
    }
}
