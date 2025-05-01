package arrays.easy;
import java.util.Arrays;

public class Q4_leftrotatebyoneplace {
    static void leftRotateByOnePlace(int a[]) {
        int temp = a[0];
        for (int i = 1; i < a.length; i++)
            a[i - 1] = a[i];
        a[a.length - 1] = temp;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        leftRotateByOnePlace(a);
        System.out.println(Arrays.toString(a));
    }
}