package dev.fastfoodapi.controller;

import dev.fastfoodapi.model.DonDatHang;
import dev.fastfoodapi.service.DonDatHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/don-dat-hang")
public class DonDatHangController {

    @Autowired
    private DonDatHangService donDatHangService;

    @GetMapping
    public List<DonDatHang> getAllDonDatHang() {
        return donDatHangService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonDatHang> getDonDatHangById(@PathVariable(value = "id") Long id) {
        try {
            DonDatHang obj = donDatHangService.findById(id).get();
            return ResponseEntity.ok().body(obj);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DonDatHang createDonDatHang(@RequestBody DonDatHang obj) {
        return donDatHangService.save(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonDatHang> updateDonDatHang(@RequestBody DonDatHang obj, @PathVariable("id") Long id) {
        DonDatHang o = donDatHangService.update(id, obj);
        return ResponseEntity.ok(o);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DonDatHang> deleteDonDatHang(@PathVariable("id") Long id) {
        try {
            donDatHangService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
