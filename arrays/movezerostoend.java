import java.util.Arrays;

public class movezerostoend {

    static void moveZerosToEnd() {
    }

    static void moveZerosToEndBrute(int a[]) {
        int n = a.length;
        int temp[] = new int[n];
        int j = 0;
        // stored elements int temp
        for (int i : a)
            if (i != 0)
                temp[j++] = i;
        // we directly copy temp to a as last unfilled slots of temp is 0 by
        // default(initial value)
        for (int i = 0; i < temp.length; i++)
            a[i] = temp[i];
    }

    // 2 pointer approach
    static void moveZerosToEndOptimal(int a[]) {
        int n = a.length;
        int j = 0;
        for (int i = 0; i < n; i++)
            if (a[i] != 0)
                a[j++] = a[i];
        for (; j < n; j++)
            a[j] = 0;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 0, 3, 0, 4, 0, 5 };
        moveZerosToEndOptimal(a);
        System.out.println(Arrays.toString(a));
    }

}
