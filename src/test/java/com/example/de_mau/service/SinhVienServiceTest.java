package com.example.de_mau.service;

import com.example.de_mau.model.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest {

    private SinhVienService service;

    @BeforeEach
    void setUp() {
        // Khởi tạo đối tượng SinhVienService trước mỗi test
        service = new SinhVienService();
    }

    @Test
    void testUpdateValidStudent() {
        // Kiểm tra trường hợp dữ liệu hợp lệ
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", 20, 8.5f, 3, "CNTT");
        assertTrue(service.updateSinhVien(sv), "Dữ liệu hợp lệ phải trả về true");
    }

    @Test
    void testUpdateEmptyMaSV() {
        // Kiểm tra khi maSV rỗng
        SinhVien sv = new SinhVien("", "Nguyen Van A", 20, 8.5f, 3, "CNTT");
        assertFalse(service.updateSinhVien(sv), "maSV rỗng phải trả về false");
    }

    @Test
    void testUpdateNullTen() {
        // Kiểm tra khi ten là null
        SinhVien sv = new SinhVien("SV001", null, 20, 8.5f, 3, "CNTT");
        assertFalse(service.updateSinhVien(sv), "ten null phải trả về false");
    }

    @Test
    void testUpdateEmptyChuyenNganh() {
        // Kiểm tra khi chuyenNganh rỗng
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", 20, 8.5f, 3, "");
        assertFalse(service.updateSinhVien(sv), "chuyenNganh rỗng phải trả về false");
    }

    @Test
    void testUpdateInvalidTuoi() {
        // Kiểm tra khi tuoi không hợp lệ (<= 0)
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", 0, 8.5f, 3, "CNTT");
        assertFalse(service.updateSinhVien(sv), "tuoi <= 0 phải trả về false");
    }

    @Test
    void testUpdateInvalidDiemTrungBinh() {
        // Kiểm tra khi diemTrungBinh không hợp lệ (< 0)
        SinhVien sv1 = new SinhVien("SV001", "Nguyen Van A", 20, -1.0f, 3, "CNTT");
        assertFalse(service.updateSinhVien(sv1), "diemTrungBinh < 0 phải trả về false");

        // Kiểm tra khi diemTrungBinh không hợp lệ (> 10)
        SinhVien sv2 = new SinhVien("SV001", "Nguyen Van A", 20, 11.0f, 3, "CNTT");
        assertFalse(service.updateSinhVien(sv2), "diemTrungBinh > 10 phải trả về false");
    }

    @Test
    void testUpdateInvalidKyHoc() {
        // Kiểm tra khi kyHoc không hợp lệ (< 1)
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", 20, 8.5f, 0, "CNTT");
        assertFalse(service.updateSinhVien(sv), "kyHoc < 1 phải trả về false");
    }
}
