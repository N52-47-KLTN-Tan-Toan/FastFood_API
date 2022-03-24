package dev.fastfoodapi.repository;


import dev.fastfoodapi.model.ChiTietDonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietDonDatHangRepo extends JpaRepository<ChiTietDonDatHang, Long> {

    @Query("SELECT ctddh FROM ChiTietDonDatHang ctddh WHERE ctddh.donDatHang.maDDH = :id")
    List<ChiTietDonDatHang> findAllByDonDatHang(Long id);

    @Query(value = "SELECT DISTINCT ct.ma_mat_hang, ct.mactddh, don_gia, \n" +
            "COUNT(ct.ma_mat_hang) AS so_luong_dat, ma_don_dat_hang \n" +
            "FROM db_fastfood.tbl_chitietdondathang ct \n" +
            "JOIN db_fastfood.tbl_dondathang d ON d.maddh = ct.ma_don_dat_hang \n" +
            "WHERE d.ngay_dat_hang = current_date() AND trang_thai = 'Đã thanh toán'" +
            "GROUP BY ct.ma_mat_hang ORDER BY so_luong_dat DESC LIMIT 0, 5", nativeQuery = true)
    List<ChiTietDonDatHang> today();

    @Query(value = "SELECT DISTINCT ct.ma_mat_hang, ngay_dat_hang, ct.mactddh, don_gia, \n" +
            "COUNT(ct.ma_mat_hang) AS so_luong_dat, ma_don_dat_hang \n" +
            "FROM db_fastfood.tbl_chitietdondathang ct \n" +
            "JOIN db_fastfood.tbl_dondathang d ON d.maddh = ct.ma_don_dat_hang \n" +
            "WHERE MONTH(ngay_dat_hang) = MONTH(NOW()) AND ngay_dat_hang >= DATE_SUB(NOW(), INTERVAL 7 DAY) \n" +
            "AND trang_thai = 'Đã thanh toán'\n" +
            "GROUP BY ct.ma_mat_hang ORDER BY so_luong_dat DESC LIMIT 0, 5", nativeQuery = true)
    List<ChiTietDonDatHang> last7days();

    @Query(value = "SELECT DISTINCT ct.ma_mat_hang, ngay_dat_hang, ct.mactddh, don_gia, \n" +
            "COUNT(ct.ma_mat_hang) AS so_luong_dat, ma_don_dat_hang \n" +
            "FROM db_fastfood.tbl_chitietdondathang ct \n" +
            "JOIN db_fastfood.tbl_dondathang d ON d.maddh = ct.ma_don_dat_hang \n" +
            "WHERE MONTH(ngay_dat_hang) = MONTH(NOW()) \n" +
            "AND trang_thai = 'Đã thanh toán'\n" +
            "GROUP BY ct.ma_mat_hang ORDER BY so_luong_dat DESC LIMIT 0, 5", nativeQuery = true)
    List<ChiTietDonDatHang> thisMonth();

    @Query(value = "SELECT DISTINCT ct.ma_mat_hang, ngay_dat_hang, ct.mactddh, don_gia, \n" +
            "COUNT(ct.ma_mat_hang) AS so_luong_dat, ma_don_dat_hang \n" +
            "FROM db_fastfood.tbl_chitietdondathang ct \n" +
            "JOIN db_fastfood.tbl_dondathang d ON d.maddh = ct.ma_don_dat_hang \n" +
            "WHERE YEAR(ngay_dat_hang) = YEAR(NOW()) \n" +
            "AND trang_thai = 'Đã thanh toán'\n" +
            "GROUP BY ct.ma_mat_hang ORDER BY so_luong_dat DESC LIMIT 0, 5", nativeQuery = true)
    List<ChiTietDonDatHang> thisYear();
}
