package dev.fastfoodapi.service;

import dev.fastfoodapi.model.NhanVien;
import dev.fastfoodapi.repository.NhanVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepo nhanVienRepo;

    //Hàm CRUD mặc định
    @Override
    public NhanVien save(NhanVien obj) {
        return nhanVienRepo.save(obj);
    }

    @Override
    public Optional<NhanVien> findById(UUID id) {
        return nhanVienRepo.findById(id);
    }

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepo.findAll();
    }

    @Override
    public NhanVien update(UUID id, NhanVien obj) {
        obj.setUserId(id);
        return nhanVienRepo.save(obj);
    }

    @Override
    public void delete(UUID id) {
        nhanVienRepo.deleteById(id);
    }

    //Một số hàm khác
    @Override
    public NhanVien findByUsername(String s) {
        return nhanVienRepo.findByUsername(s);
    }

    @Override
    public String findRoleNameByUsername(String s) {
        return nhanVienRepo.findRoleNameByUsername(s);
    }

    @Override
    public boolean existsByUsername(String s) {
        if (nhanVienRepo.findByUsername(s) == null) {
            return true;
        } else {
            return false;
        }
    }

}
