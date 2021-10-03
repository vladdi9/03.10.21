package org.itstep;

public class Qs2 {
    static int[] arr = {2, 5, 6, 9, 11};
    public static void main(String[] args) {
        // Бинарный поиск элементов в массиве
        binarySearch(5);
        System.out.println(binarySearch(5));
    }

    public static int binarySearch(int number) {
        int a = 0, b = arr.length - 1, m = (a + b) / 2, result = 0;
        while ((a != b) & arr[m] != number) {
            if (number > arr[m])
                a = m;
            else b = m;
            m = (a + b) / 2;
        }
        if (arr[m] == number)
            return m;
        else {
            return -1;
        }
    }
}
