package greedy_algorithm.easy;

import java.util.Arrays;

class item {
    int value;
    int weight;

    item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Q13_fractionknapsack {
    public static int sol(item[] items, int w) {
        int n = items.length;
        Arrays.sort(items, (a, b) -> (b.value / b.weight) - (a.value / a.weight));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int value = Math.min(items[i].weight, w);
            ans += value * (items[i].value / items[i].weight);
            w -= value;
            if (w == 0)
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        item[] items = { new item(60, 10), new item(100, 20), new item(120, 30) };
        System.out.println(sol(items, 50));
    }
}
