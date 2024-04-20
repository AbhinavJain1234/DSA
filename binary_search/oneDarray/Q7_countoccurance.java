package binary_search.oneDarray;

public class Q7_countoccurance {
    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10 };
        int index[] = Q6_firstlastoccurance.searchRange(a, 9);
        if (index[0] == -1)
            System.out.println(0);
        else
            System.out.println(index[1] - index[0] + 1);
    }

}
