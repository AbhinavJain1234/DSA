public class maximumconsecutiveone {
    static int maximumConsecutiveOne(int a[]) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count++;
                if (count > max)
                    max = count;
            } else
                count = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int a[] = { 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(maximumConsecutiveOne(a));
    }
}
