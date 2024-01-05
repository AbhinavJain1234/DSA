public class linearsearch {

    static int linearSearch(int a[], int search) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == search)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int search = 9;
        System.out.println("index is " + linearSearch(a, search));
    }

}
