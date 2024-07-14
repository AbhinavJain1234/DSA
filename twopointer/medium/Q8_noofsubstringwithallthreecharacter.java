package twopointer.medium;

public class Q8_noofsubstringwithallthreecharacter {
    public static int numberOfSubstringsbrute(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int hash[] = new int[3];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] == 1 && hash[1] == 1 && hash[2] == 1) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }

    public static int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[] last = { -1, -1, -1 };

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            last[ch - 'a'] = i;
            int minLast = Math.min(last[0], Math.min(last[1], last[2]));
            count += minLast + 1;

        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsbrute(s));
    }
}
