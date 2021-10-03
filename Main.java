package org.itstep;

import java.util.Random;

public class Main {
    public static int size = 1_000_000;
    public static int[] arr = new int[size];
    public static int RUN = 32;

    public static void main(String[] args) {
        fillRandom();
        long start = System.nanoTime();
        //quickSort(0, arr.length -1);
        //print();
             //
        //merge();
        //mergeSort(0, arr.length-1);
             //
        //heapSort();
             //
        timSort();
        //print();
        //bubbleSort();
        long and = System.nanoTime();
        //double time = (end - start)/1e+9;
        //System.out.println("time"+time);
    }
    public static void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(81) + 10;
        }
    }

    public static void print() {
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int low, int high) {
        if (arr.length == 0)
            return;//завершить выполнение если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = arr[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }
            while (arr[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                swap(i,j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j);
        if (high > i)
            quickSort(i, high);
    }
    //Слияние внутри одного массива
    public static void merge(int l, int m, int r)
    {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right  = new int [len2];
        for (int i = 0; i < len1; i++)
            left[i] = arr[l + i];
        for (int i = 0; i < len2; i++)
            right[i] = arr[m + 1 + i];
        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we
        // merge those two array
        // in larger sub array
        while (i < len1 && j < len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left, if any
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copy remaining element of right, if any
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
    //Сортировка слиянием
    public static void mergeSort(int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            swap(i,largest);
            // Recursively heapify the affected sub-tree
            heapify(n, largest);
        }
    }
    public static void heapSort()
    {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            swap(0,i);
            // call max heapify on the reduced heap
            heapify(i, 0);
        }
    }
    public static void timSort()
    {
        int n = arr.length;
        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i+=RUN)
            insertionSort(i, min((i+RUN-1),
                    (n-1)));

        // Start merging from size RUN (or 32).
        // It will merge
        // to form size 64, then 128, 256
        // and so on ....
        for (int size = RUN; size < n;
             size = 2*size)
        {

            // pick starting point of
            // left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n;
                 left += 2*size)
            {

                // find ending point of
                // left sub array
                // mid+1 is starting point
                // of right sub array
                int mid = left + size - 1;
                int right = min((left + 2*size - 1),
                        (n-1));

                // merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if(mid < right)
                    merge(left, mid, right);
            }
        }
    }
    public static void insertionSort(int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    public static void bubbleSort() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    //printColor(j, j + 1);
                    swap(j, j + 1);
                }
    }
}
