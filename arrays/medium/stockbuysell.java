package medium;

public class stockbuysell {
    public static void sol(int a[]) {
        int mini = a[0];
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            int newProfit = a[i] - mini;
            profit = Math.max(profit, newProfit);
            mini = Math.min(a[i], mini);
        }
        System.out.println("Max Profit:" + profit);
    }

    public static void main(String[] args) {
        int a[] = { 7, 1, 5, 3, 6, 4 };
        sol(a);
    }
}
