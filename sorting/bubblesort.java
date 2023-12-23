package sorting;

public class bubblesort {

    // normal
    static void bubbleSort(int a[]) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
            }
        }
    }

    // with optimization
    static void bubbleSortwithoptimisation(int a[]) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            int c = 0;
            for (int j = 0; j < l - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    c++;// counter for optimization
                }
            }
            if (c == 0)
                break;
        }
    }

    // with recursion
    // if adjacent element is small be swap if c iteration line no 40
    // if(c>=r) then the largest element in that array is at the last
    static void bubbleSortwithrecursion(int a[], int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            if (a[c] > a[c + 1])
                swap(a, c + 1, c);
            bubbleSortwithrecursion(a, r, c + 1);
        } else
            bubbleSortwithrecursion(a, r - 1, 0);

    }

    static void swap(int a[], int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 13, 46, 24, 52, 20, 9 };
        int b[] = { 1, 2, 3, 4, 5, 6 };
        int c[] = { 5, 4, 3, 2, 1, 6, 7 };
        bubbleSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        bubbleSortwithoptimisation(b);
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();
        bubbleSortwithrecursion(c, c.length - 1, 0);
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
    }
}
