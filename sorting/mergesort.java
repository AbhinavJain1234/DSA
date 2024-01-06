package sorting;

public class mergesort {
    public static void mergeSort(int[] a, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    static void merge(int[] a, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int i = 0;
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                temp[i++] = a[left++];
            } else {
                temp[i++] = a[right++];
            }
        }
        while (left <= mid) {
            temp[i++] = a[left++];
        }
        while (right <= high) {
            temp[i++] = a[right++];
        }
        for (int j = low; j <= high; j++)
            a[j] = temp[j - low];
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

}
