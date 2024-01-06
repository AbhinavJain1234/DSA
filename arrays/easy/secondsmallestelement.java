package easy;

public class secondsmallestelement {
    static int secondSmallestBrute(int a[]) {
        quicksort.quickSort(a, 0, a.length - 1);
        int n = 1;
        while (a[0] == a[n] && n < a.length)
            n++;
        if (a[0] != a[n])
            return a[n];
        else
            return -1;
    }

    static int secondSmallestBetter(int a[]) {
        int smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest > a[i])
                smallest = a[i];
        }
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (secondSmallest > a[i] && a[i] > smallest)
                secondSmallest = a[i];
        }
        return secondSmallest;
    }

    static int secondSmallestBest(int a[]) {
        int smallest = a[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (smallest > a[i]) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (smallest < a[i] && secondSmallest > a[i])
                secondSmallest = a[i];
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        int a[] = { 9, 5, 4, 3, 7, 9 };
        System.out.println(secondSmallestBetter(a));
        System.out.println(secondSmallestBest(a));
        System.out.println(secondSmallestBrute(a));
    }
}
