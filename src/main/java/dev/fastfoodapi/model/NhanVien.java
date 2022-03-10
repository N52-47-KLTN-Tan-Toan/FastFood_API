package dev.fastfoodapi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_nhanvien")
public class NhanVien extends User{

    private String username;

}
