package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Sort {
    public static <T extends Comparable<T>> void sort(T[] data) {
        introSort(data, 0, data.length-1, Math.log(data.length)/Math.log(2));
    }

    private static <T extends Comparable<T>> void introSort(T[] data, int start, int end, double maxDepth) {
        if (start >= end)
            return;
        if (end - start < 15) {
            insertionSort(data, start, end);
        } else if (maxDepth <= 0) {
            heapSort(data, start, end);
        } else {
            T pivot;
            int p;
            int a = start;
            int b = (start + end) / 2;
            int c = end;
            if (data[a].compareTo(data[b]) > 0) {
                if (data[a].compareTo(data[c]) > 0) {
                    if (data[b].compareTo(data[c]) > 0)
                        p = b;
                    else
                        p = c;
                } else
                    p = a;
            } else if (data[a].compareTo(data[c]) < 0) {
                if (data[b].compareTo(data[c]) > 0)
                    p = b;
                else
                    p = c;
            } else
                p = a;
            pivot = data[p];

            swap(data, p, end);
            int l = start;
            int r = end - 1;
            while (l <= r) {
                while (l <= end-1 && data[l].compareTo(pivot) < 0) {
                    l++;
                }
                while (r >= start && data[r].compareTo(pivot) >= 0) {
                    r--;
                }
                if (l < r)
                    swap(data, l, r);
            }
            swap(data, l, end);

            introSort(data, start, l-1, maxDepth-1);
            introSort(data, l+1, end, maxDepth-1);
        }
    }

    private static <T extends Comparable<T>> void heapSort(T[] data, int start, int end) {

    }

    private static <T extends Comparable<T>> void insertionSort(T[] data, int start, int end) {

    }

    private static <T> void swap(T[] data, int a, int b) {
        T tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
