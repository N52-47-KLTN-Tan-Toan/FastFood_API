package dev.fastfoodapi.controller;

import dev.fastfoodapi.model.LoaiMatHang;
import dev.fastfoodapi.service.LoaiMatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/loai-mat-hang")
public class LoaiMatHangController {

    @Autowired
    private LoaiMatHangService loaiMatHangService;

    @GetMapping
    public List<LoaiMatHang> getAllLoaiMatHang(){
        return loaiMatHangService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiMatHang> getLoaiMatHangById(@PathVariable(value = "id") Long id) {
        try {
            LoaiMatHang obj = loaiMatHangService.findById(id).get();
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LoaiMatHang createLoaiMatHang(@RequestBody LoaiMatHang obj) {
        return loaiMatHangService.save(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiMatHang> updateLoaiMatHang(@RequestBody LoaiMatHang obj, @PathVariable("id") Long id) {
        LoaiMatHang o = loaiMatHangService.update(id, obj);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiMatHang> deleteLoaiMatHang(@PathVariable("id") Long id) {
        try {
            loaiMatHangService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
