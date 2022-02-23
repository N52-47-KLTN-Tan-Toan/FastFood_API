package dev.fastfoodapi.controller;

import dev.fastfoodapi.model.MatHang;
import dev.fastfoodapi.service.MatHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/mat-hang")
public class MatHangController {

    @Autowired
    private MatHangService matHangService;

    @GetMapping
    public List<MatHang> getAllMatHang(){
        return matHangService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatHang> getMatHangById(@PathVariable(value = "id") Long id) {
        try {
            MatHang obj = matHangService.findById(id).get();
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MatHang createMatHang(@RequestBody MatHang obj) {
        return matHangService.save(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatHang> updateMatHang(@RequestBody MatHang obj, @PathVariable("id") Long id) {
        MatHang o = matHangService.update(id, obj);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MatHang> deleteMatHang(@PathVariable("id") Long id) {
        try {
            matHangService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
