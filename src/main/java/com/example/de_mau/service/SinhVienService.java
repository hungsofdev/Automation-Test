package com.example.de_mau.service;

import com.example.de_mau.model.SinhVien;

public class SinhVienService {
    /**
     * Sửa thông tin sinh viên.
     *
     * @param sv Đối tượng sinh viên cần sửa.
     * @return true nếu sửa thành công, false nếu dữ liệu không hợp lệ.
     */
    public boolean updateSinhVien(SinhVien sv) {
        // Kiểm tra các trường bắt buộc không được null hoặc rỗng
        if (sv.getMaSV() == null || sv.getMaSV().isEmpty() ||
                sv.getTen() == null || sv.getTen().isEmpty() ||
                sv.getChuyenNganh() == null || sv.getChuyenNganh().isEmpty()) {
            return false; // Trả về false nếu một trong các trường này không hợp lệ
        }

        // Kiểm tra các giá trị số hợp lệ
        if (sv.getTuoi() <= 0 ||             // Tuổi phải lớn hơn 0
                sv.getDiemTrungBinh() < 0 ||     // Điểm trung bình không được âm
                sv.getDiemTrungBinh() > 10 ||    // Điểm trung bình không vượt quá 10
                sv.getKyHoc() < 1) {             // Kỳ học phải từ 1 trở lên
            return false; // Trả về false nếu không thỏa mãn
        }

        // Giả sử logic sửa thành công (ví dụ: lưu vào database)
        return true;
    }
}