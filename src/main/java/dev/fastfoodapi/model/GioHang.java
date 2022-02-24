package dev.fastfoodapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_giohang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long maGH;

    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "ma_mat_hang")
    private MatHang matHang;

}
