package dev.fastfoodapi.controller;

import dev.fastfoodapi.model.KhachHang;
import dev.fastfoodapi.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public Page<KhachHang> getAllKhachHang(Pageable pageable) {
        return khachHangService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable(value = "id") UUID id) {
        try {
            KhachHang obj = khachHangService.findById(id).get();
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang obj) {
        return khachHangService.save(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateKhachHang(@RequestBody KhachHang obj, @PathVariable("id") UUID id) {
        KhachHang o = khachHangService.update(id, obj);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<KhachHang> deleteKhachHang(@PathVariable("id") UUID id) {
        try {
            khachHangService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
