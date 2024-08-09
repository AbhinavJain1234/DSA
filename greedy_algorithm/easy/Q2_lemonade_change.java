package greedy_algorithm.easy;

public class Q2_lemonade_change {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int p = bills[i];
            if (p == 5)
                five++;
            else if (p == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else
                    return false;
            } else {
                if (ten >= 1 && five >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[] { 5, 5, 5, 10, 20 }));
    }
}
