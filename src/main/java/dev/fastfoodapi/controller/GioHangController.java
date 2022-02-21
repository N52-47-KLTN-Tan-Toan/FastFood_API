package dev.fastfoodapi.controller;

import dev.fastfoodapi.model.GioHang;
import dev.fastfoodapi.service.GioHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/gio-hang")
public class GioHangController {

    @Autowired
    private GioHangService gioHangService;

    @GetMapping
    public List<GioHang> getAllGioHang() {
        return gioHangService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GioHang> getGioHangById(@PathVariable(value = "id") Long id) {
        try {
            GioHang obj = gioHangService.findById(id).get();
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public GioHang createGioHang(@RequestBody GioHang obj) {
        return gioHangService.save(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GioHang> updateGioHang(@RequestBody GioHang obj, @PathVariable("id") Long id) {
        GioHang o = gioHangService.update(id, obj);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GioHang> deleteGioHang(@PathVariable("id") Long id) {
        try {
            gioHangService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}