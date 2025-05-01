package arrays.medium;


class q4_maxsubarraysum {

    public static int solOptimal(int a[]) {
        int sum = 0;
        int maxSum = sum;
        for (int i = 0; i < a.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += a[i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

    public static int solOptimalExtended(int a[]) {
        int sum = 0;
        int maxSum = sum;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int index = 0; index < a.length; index++) {
            if (sum == 0)
                start = index;
            sum += a[index];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = index;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
        return maxSum;
    }

    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3, 9, 9, 9, 9, 9, 9, -67 };
        System.out.println(solOptimal(a));
        System.out.println(solOptimalExtended(a));
    }
}