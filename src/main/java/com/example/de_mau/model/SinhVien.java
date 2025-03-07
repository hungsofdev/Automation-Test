package com.example.de_mau.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Tự động sinh getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Tạo constructor không tham số
@AllArgsConstructor // Tạo constructor có tất cả tham số
public class SinhVien {
    private String maSV;         // Mã sinh viên
    private String ten;          // Tên sinh viên
    private int tuoi;            // Tuổi
    private float diemTrungBinh; // Điểm trung bình
    private int kyHoc;           // Kỳ học
    private String chuyenNganh;  // Chuyên ngành
}