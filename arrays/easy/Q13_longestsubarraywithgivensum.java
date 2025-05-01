package arrays.easy;

import java.util.HashMap;

public class Q13_longestsubarraywithgivensum {
    static void solBrute(int a[], int sum) {
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            int sum1 = 0;
            for (int j = i; j < a.length; j++) {

                // better way to find sum
                sum1 += a[j];

                // default way to find sum
                // int sum2 = 0;
                // for (int k = 0; k < a.length; k++) {
                // sum2 += a[k];
                // }
                if (sum1 == sum)
                    maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        System.out.println(maxLength);
    }

    // only positive+negatives
    // best with negative
    // better for only positive
    static void solBetter1(int a[], int sum) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sumArray = 0;
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            sumArray += a[i];
            if (sumArray == sum)
                maxLength = Math.max(maxLength, i + 1);
            long rem = sumArray - sum;
            if (map.containsKey(rem)) {
                int length = i - map.get(rem);
                maxLength = Math.max(maxLength, length);
            }
            map.put(sumArray, i);
        }
        System.out.println(maxLength);
    }

    // positive+zeros+negatives
    // best if we include all
    // better for only positive
    static void solBetter2(int a[], int sum) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sumArray = 0;
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            sumArray += a[i];
            if (sumArray == sum)
                maxLength = Math.max(maxLength, i + 1);
            long rem = sumArray - sum;
            if (map.containsKey(rem)) {
                int length = i - map.get(rem);
                maxLength = Math.max(maxLength, length);
            }
            if (!map.containsKey(sumArray))// modification done here
                map.put(sumArray, i);
        }
        System.out.println(maxLength);
    }

    // optimal for positive and zero
    static void solOptimal(int a[], int sum) {
        int i = 1, j = 0, n = a.length;
        int tempSum = a[0];
        int maxLength = 0;
        while (i < n) {
            while (tempSum > sum && j <= i)
                tempSum -= a[j++];
            if (tempSum == sum)
                maxLength = Math.max(maxLength, i - j);
            tempSum += a[i++];
        }
        System.out.println(maxLength);
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 1, 1, 1, 1, 5, -1, -1, -1, -1, 3, 2 };
        solBrute(a, 3);
        solBetter1(a, 3);
        solBetter2(a, 3);
        int b[] = { 1, 2, 3, 1, 1, 1, 1, 3, 3 };
        solOptimal(b, 6);
    }
}
