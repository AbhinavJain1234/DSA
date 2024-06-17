package string.medium;

import java.util.HashMap;

public class Q3_romannumber {
    public static int romantoint(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (map.get(ch) < map.get(ch1))
                sum -= map.get(ch);
            else
                sum += map.get(ch);
        }
        sum += map.get(s.charAt(s.length() - 1));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romantoint("MCMXCIV"));
    }
}
