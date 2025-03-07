package com.example.de_mau.utils;

public class ArrayUtils {
    /**
     * Tính tổng của các phần tử trong mảng số nguyên.
     *
     * @param array Mảng số nguyên đầu vào.
     * @return Tổng của các phần tử trong mảng, hoặc 0 nếu mảng rỗng hoặc null.
     */
    public static int calculateSum(int[] array) {
        // Kiểm tra nếu mảng là null hoặc rỗng, trả về 0
        if (array == null || array.length == 0) {
            return 0;
        }
        // Khởi tạo biến sum để lưu tổng
        int sum = 0;
        // Duyệt qua từng phần tử trong mảng và cộng vào sum
        for (int num : array) {
            sum += num;
        }
        // Trả về kết quả tổng
        return sum;
    }
}
