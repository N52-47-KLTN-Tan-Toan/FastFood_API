package dev.fastfoodapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_khachhang")
public class KhachHang extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<GioHang> gioHangList;

    @JsonIgnore
    @OneToMany(mappedBy = "khachHang")
    private List<DonDatHang> donDatHangList;
}
