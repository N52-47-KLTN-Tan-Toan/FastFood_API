package dev.fastfoodapi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_giohang")
public class GioHang {

    @Id
    @Generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long maGH;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private KhachHang khachHang;

    private int soLuong;
}
