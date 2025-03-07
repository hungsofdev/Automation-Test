package com.example.de_mau.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtilsTest {

    @Test
    void testEmptyArray() {
        // Kiểm tra trường hợp mảng rỗng
        int[] array = {};
        assertEquals(0, ArrayUtils.calculateSum(array), "Mảng rỗng phải trả về 0");
    }

    @Test
    void testNullArray() {
        // Kiểm tra trường hợp mảng là null
        int[] array = null;
        assertEquals(0, ArrayUtils.calculateSum(array), "Mảng null phải trả về 0");
    }

    @Test
    void testSingleElement() {
        // Kiểm tra mảng chỉ có một phần tử
        int[] array = {5};
        assertEquals(5, ArrayUtils.calculateSum(array), "Mảng một phần tử phải trả về giá trị của phần tử đó");
    }

    @Test
    void testPositiveNumbers() {
        // Kiểm tra mảng toàn số dương
        int[] array = {1, 2, 3, 4};
        assertEquals(10, ArrayUtils.calculateSum(array), "Tổng của mảng số dương phải là 10");
    }

    @Test
    void testNegativeNumbers() {
        // Kiểm tra mảng toàn số âm
        int[] array = {-1, -2, -3, -4};
        assertEquals(-10, ArrayUtils.calculateSum(array), "Tổng của mảng số âm phải là -10");
    }

    @Test
    void testMixedNumbers() {
        // Kiểm tra mảng có số dương, âm và 0
        int[] array = {1, -1, 0, 2, -2};
        assertEquals(0, ArrayUtils.calculateSum(array), "Tổng của mảng hỗn hợp phải là 0");
    }
}