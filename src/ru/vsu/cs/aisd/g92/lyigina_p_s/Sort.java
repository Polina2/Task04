package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Sort {
    public static <T extends Comparable<T>> void sort(T[] data) {
        introSort(data, 0, data.length-1, Math.log(data.length)/Math.log(2));
    }

    private static <T extends Comparable<T>> void introSort(T[] data, int start, int end, double maxDepth) {
        if (start >= end)
            return;
        if (end - start < 15) {

            for (int i = start; i <= end; i++)
                System.out.print(data[i] + " ");
            System.out.println("insertion sort ->");

            insertionSort(data, start, end);

            for (int i = start; i <= end; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        } else if (maxDepth <= 0) {

            for (int i = start; i <= end; i++)
                System.out.print(data[i] + " ");
            System.out.println("heap sort ->");

            heapSort(data, start, end);

            for (int i = start; i <= end; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        } else {
            T pivot;
            int p;
            int middle = (start + end) / 2;
            if (data[start].compareTo(data[middle]) > 0) {
                if (data[start].compareTo(data[end]) > 0) {
                    if (data[middle].compareTo(data[end]) > 0)
                        p = middle;
                    else
                        p = end;
                } else
                    p = start;
            } else if (data[start].compareTo(data[end]) < 0) {
                if (data[middle].compareTo(data[end]) > 0)
                    p = middle;
                else
                    p = end;
            } else
                p = start;
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
        for (int i = (end+start-1)/2; i > start; i--)
            sift(data, i, start, end);
        for (int i = end; i > start; i--) {
            sift(data, start, start, i);
            swap(data, start, i);
        }
    }

    private static <T extends Comparable<T>> void sift(T[] data, int k, int start, int end) {
        T value = data[k];
        while (true) {
            int childInd = 2*(k-start)+1+start;
            if (childInd > end)
                break;
            if (childInd+1 <= end && data[childInd+1].compareTo(data[childInd])>0)
                childInd++;
            if (data[childInd].compareTo(value) < 0)
                break;
            data[k] = data[childInd];
            k = childInd;
        }
        data[k] = value;
    }

    private static <T extends Comparable<T>> void insertionSort(T[] data, int start, int end) {
        int i = start+1;
        while (i <= end) {
            int j = i;
            while (j > start && data[j].compareTo(data[j-1]) < 0) {
                swap(data, j, j - 1);
                j--;
            }
            i++;
        }
    }

    private static <T> void swap(T[] data, int a, int b) {
        T tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
