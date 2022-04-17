package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Sort {
    public static <T extends Comparable<T>> void sort(T[] data) {
        introSort(data, 0, data.length-1, Math.log((double) data.length)/Math.log(2.0));
    }

    private static <T extends Comparable<T>> void introSort(T[] data, int start, int end, double maxDepth) {
        if (end - start < 15) {
            insertionSort(data, start, end);
        } else if (maxDepth <= 0) {
            heapSort(data, start, end);
        } else {
            T pivot;
            T a = data[start];
            T b = data[(start + end) / 2];
            T c = data[end];
            if (a.compareTo(b) > 0) {
                if (a.compareTo(c) > 0) {
                    if (b.compareTo(c) > 0)
                        pivot = b;
                    else
                        pivot = c;
                } else
                    pivot = a;
            } else if (a.compareTo(c) < 0) {
                if (b.compareTo(c) > 0)
                    pivot = b;
                else
                    pivot = c;
            } else
                pivot = a;

            swap(pivot, data[end]);
            int l = start;
            int r = end - 1;
            while (l < r) {
                while (data[l].compareTo(pivot) < 0) {
                    l++;
                }
                while (data[r].compareTo(pivot) >= 0) {
                    r--;
                }
                if (l < r)
                    swap(data[l], data[r]);
            }
            swap(data[l], pivot);
            introSort(data, start, r, maxDepth-1);
            introSort(data, l+1, end, maxDepth-1);
        }
    }

    private static <T extends Comparable<T>> void heapSort(T[] data, int start, int end) {

    }

    private static <T extends Comparable<T>> void insertionSort(T[] data, int start, int end) {

    }

    private static <T> void swap(T a, T b) {
        T tmp = a;
        a = b;
        b = tmp;
    }
}
