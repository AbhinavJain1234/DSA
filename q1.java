
import java.util.*;

class q1 {
    static int maxPairs(int a[], int b[], int n) {
        Arrays.sort(a);
        Arrays.sort(b);

        int maxPairs = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (a[i] > b[j]) {
                maxPairs++;
                i++;
                j++;
            } else {
                i++;
            }
        }

        return maxPairs;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of arrays: ");
        int n = scanner.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        System.out.println("Enter elements of array a:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println("Enter elements of array b:");
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println("Maximum number of pairs: " + maxPairs(a, b, n));
        scanner.close();
    }
}