package sorting;

public class selectionsort {

    // normal
    static void selectionSort(int a[]) {
        int l = a.length;
        for (int i = 0; i <= l - 2; i++) {
            int index = i;
            for (int j = i + 1; j <= l - 1; j++) {
                if (a[index] > a[j])
                    index = j;
            }
            if (index != i) {
                swap(a, index, i);
            }
        }
    }

    // recursion
    // find max element is c iterations line no 27,29 and keep changing largest
    // element index
    // then swap is to the last
    static void selectionSortRecursion(int a[], int r, int c, int max) {
        if (r == 0)
            return;
        if (c < r) {
            if (a[c] > a[max])
                selectionSortRecursion(a, r, c + 1, c);
            else
                selectionSortRecursion(a, r, c + 1, max);
        } else {
            swap(a, r, max);
            selectionSortRecursion(a, r - 1, 0, max);
        }
    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 13, 46, 24, 52, 20, 9 };
        selectionSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        int b[] = { 13, 46, 24, 52, 20, 9 };
        selectionSortRecursion(b, b.length - 1, 0, 0);
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
    }
}
