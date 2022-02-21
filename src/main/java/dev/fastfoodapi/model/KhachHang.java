package dev.fastfoodapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "tbl_khachhang")
public class KhachHang extends User{

    @JsonIgnore
    @OneToMany(mappedBy = "khachHang")
    private List<GioHang> gioHangList;

}
