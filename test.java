import java.util.HashMap;

public class test {
    static int fun(int arr[], int x) {
        int n = arr.length;
        if (x == 0) {
            int p = 1;
            for (int i = 1; i <= n; i++)
                p *= i;
            return p;
        }
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ans = 0;
        while (r < n) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.get(arr[r]) == 3) {
                count++;

            }
            while (count == x) {
                ans += (n - r);
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 2) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return ans;
    }

    static int exact(int arr[], int x) {
        return fun(arr, x) - fun(arr, x + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 3, 2, 5, 3, 3, 5 };
        System.out.println(exact(arr, 2));
    }
}
