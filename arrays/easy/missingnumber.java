package easy;

import java.util.HashMap;

import javax.sound.midi.Soundbank;

public class missingnumber {

    // brute
    static int missingNumberBrute(int a[], int n) {
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    // better
    static int missingNumberBetter(int a[], int n) {
        int hash[] = new int[n + 1];
        for (int i = 0; i < n - 1; i++)
            hash[a[i]]++;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    // OPTIMAL 1
    static int missingNumberOptimal1(int a[], int n) {
        int sum = n * (n + 1) / 2;
        int arraySum = 0;
        for (int element : a) {
            arraySum += element;
        }
        if (sum == arraySum)
            return -1;
        else
            return sum - arraySum;
    }

    static int missingNumberOptimal2(int a[], int n) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ i + 1;
            xor2 = xor2 ^ a[i];
        }
        xor1 ^= n;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        // works if exactly one is missing
        int a[] = { 1, 2, 3, 5 };
        System.out.println(missingNumberBrute(a, 5));
        System.out.println(missingNumberBetter(a, 5));
        System.out.println(missingNumberOptimal1(a, 5));
        System.out.println(missingNumberOptimal2(a, 5));
    }

}
