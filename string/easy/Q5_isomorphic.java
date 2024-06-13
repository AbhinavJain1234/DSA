package string.easy;

import java.util.HashMap;

public class Q5_isomorphic {
    public static boolean iso(String a, String b) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                if (map.get(a.charAt(i)) != b.charAt(i)) {
                    return false;
                }
            } else {
                map.put(a.charAt(i), b.charAt(i));
            }
            if (map2.containsKey(b.charAt(i))) {
                if (map2.get(b.charAt(i)) != a.charAt(i)) {
                    return false;
                }
            } else {
                map2.put(b.charAt(i), a.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(iso("tiplh", "paper"));
    }
}
