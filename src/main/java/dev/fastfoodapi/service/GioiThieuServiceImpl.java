package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioiThieu;
import dev.fastfoodapi.repository.GioiThieuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioiThieuServiceImpl implements GioiThieuService{

    @Autowired
    private GioiThieuRepo gioiThieuRepo;

    @Override
    public GioiThieu save(GioiThieu obj) {
        return gioiThieuRepo.save(obj);
    }

    @Override
    public Optional<GioiThieu> findById(Long id) {
        return gioiThieuRepo.findById(id);
    }

    @Override
    public List<GioiThieu> findAll() {
        return gioiThieuRepo.findAll();
    }

    @Override
    public GioiThieu update(Long id, GioiThieu obj) {
        obj.setMaGT(id);
        return gioiThieuRepo.save(obj);
    }

    @Override
    public void delete(Long id) {
        gioiThieuRepo.deleteById(id);
    }
}
