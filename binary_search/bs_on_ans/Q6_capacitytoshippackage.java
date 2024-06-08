package binary_search.bs_on_ans;

public class Q6_capacitytoshippackage {
    public static boolean ispossible(int arr[], int capa, int days) {
        int n = arr.length;
        int nday = 0;
        int remainingcapacity = capa;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= remainingcapacity) {
                remainingcapacity -= arr[i];
            } else {
                nday++;
                remainingcapacity = capa - arr[i];
                if (remainingcapacity < 0)
                    return false;
            }
        }
        if (remainingcapacity != capa)
            nday++;
        return nday <= days;
    }

    public static int capacityoptimal(int arr[], int days) {
        int n = arr.length;
        int intial = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            intial = Math.max(intial, arr[i]);
            sum += arr[i];
        }
        while (intial <= sum) {
            int mid = intial + (sum - intial) / 2;
            if (ispossible(arr, mid, days)) {
                sum = mid - 1;
            } else
                intial = mid + 1;
        }
        return intial;
    }

    public static int capacitylinear(int arr[], int days) {
        int n = arr.length;
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        for (int i = low; i <= high; i++) {
            if (ispossible(arr, i, days)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(capacityoptimal(arr, 5));
        System.out.println(capacitylinear(arr, 5));
    }
}
