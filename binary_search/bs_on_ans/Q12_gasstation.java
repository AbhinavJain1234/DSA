package binary_search.bs_on_ans;

import java.util.*;

public class Q12_gasstation {

    public static double gasStationbrute(int arr[], int k) {
        int n = arr.length;
        int allocated[] = new int[n - 1];
        for (int i = 1; i <= k; i++) {
            double max = -1;
            int maxindex = -1;
            for (int j = 0; j < n - 1; j++) {
                double space = arr[j + 1] - arr[j];
                double len = space / (double) (allocated[j] + 1);
                if (max < len) {
                    max = len;
                    maxindex = j;
                }
            }
            allocated[maxindex]++;
        }
        double maxans = -1;
        for (int i = 0; i < n - 1; i++) {
            maxans = Math.max(maxans, (arr[i + 1] - arr[i]) / (double) (1 + allocated[i]));
        }
        return maxans;
    }

    // priority queue
    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double gasStationbetter(int arr[], int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        Queue<Pair> allocated = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for (int i = 0; i < n - 1; i++) {
            allocated.add(new Pair(arr[i + 1] - arr[i], 0));
        }
        for (int i = 1; i <= k; i++) {
            Pair p = allocated.poll();
            int secInd = p.second;
            howMany[secInd]++;
            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            allocated.add(new Pair(newSecLen, secInd));
        }
        return allocated.peek().first;
    }

    public static double gasStationoptimal(int arr[], int k) {
        int n = arr.length;
        double low = 0;
        double high = -1;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        while (high - low > 10e-6) {
            double mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                low = mid;
            } else
                high = mid;
        }
        return high;
    }

    public static boolean isPossible(int arr[], int k, double dist) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt > k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(gasStationbrute(arr, 4));
        System.out.println(gasStationbetter(arr, 4));
        System.out.println(gasStationoptimal(arr, 4));
    }
}
