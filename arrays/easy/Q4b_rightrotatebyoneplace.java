package arrays.easy;
import java.util.Arrays;

public class Q4b_rightrotatebyoneplace {
    static void rightRotateByOnePlace(int a[]) {
        int temp = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--)
            a[i] = a[i - 1];
        a[0] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        rightRotateByOnePlace(a);
        System.out.println(Arrays.toString(a));
    }
}
