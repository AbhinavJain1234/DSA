import java.util.HashMap;
import java.util.Map;

public class numberthatappearsonce {

    static int numberThatAppearsOnceBrute(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j])
                    count++;
            }
            if (count != 2)
                return a[i];
        }
        return -1;
    }

    static int numberThatAppearsOnceBetter1(int arr[]) {
        int maxi = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        int[] hash = new int[maxi + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }
        return -1;
    }

    static int numberThatAppearsOnceBetter2(int arr[]) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }

    static int numberThatAppearsOnceOptimal(int a[]) {
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, };
        System.out.println(numberThatAppearsOnceBrute(a));
        System.out.println(numberThatAppearsOnceBetter1(a));
        System.out.println(numberThatAppearsOnceBetter2(a));
        System.out.println(numberThatAppearsOnceOptimal(a));
    }
}
