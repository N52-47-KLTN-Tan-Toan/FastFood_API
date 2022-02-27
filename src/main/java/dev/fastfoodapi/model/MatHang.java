package dev.fastfoodapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_mathang")
public class MatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maMH;

    private String tenMH;

    private String moTa;

    private Double donGia;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    private String donViTinh;

    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "ma_lmh")
    private LoaiMatHang loaiMatHang;

    @JsonIgnore
    @OneToMany(mappedBy = "matHang")
    private List<GioHang> gioHangList;
}
