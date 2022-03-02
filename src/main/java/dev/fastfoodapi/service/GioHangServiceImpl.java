package dev.fastfoodapi.service;

import dev.fastfoodapi.model.GioHang;
import dev.fastfoodapi.repository.GioHangRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GioHangServiceImpl implements GioHangService{

    @Autowired
    private GioHangRepo gioHangRepo;

    //Hàm CRUD mặc định
    @Override
    public GioHang save(GioHang obj) {
        obj.setSoLuong(obj.getSoLuong() + 1);
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

    //Một số hàm khác
    @Override
    public boolean findByKhachHangAndMatHang(UUID userId, Long maMH) {
        if(gioHangRepo.findByKhachHangAndMatHang(userId, maMH) != null){
            return true;
        }else {
            return false;
        }
    }
}
