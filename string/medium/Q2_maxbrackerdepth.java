package string.medium;

public class Q2_maxbrackerdepth {
    public static int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (s.charAt(i) == ')')
                count--;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("1+(2*3)/(2-1)"));
    }
}
