package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {62, 89, 98, 7, 90, 1, 29, 27, 24, 75, 39, 62, 61, 9, 1, 56, 75, 45, 22, 4, 72, 62, 75, 13, 3, 92, 88, 92, 11, 3, 45, 21, 23, 81, 29, 71, 3, 2, 32, 59, 81, 66, 41, 64, 29, 88, 6, 41, 60, 13};
        Sort.sort(arr);
        for (Integer i : arr)
            System.out.print(i + " ");
    }
}
