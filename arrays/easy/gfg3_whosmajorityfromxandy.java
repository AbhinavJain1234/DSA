package easy;

/**
 * Given an array arr[] of size N and two elements x and y,
 * use counter variables to find which element appears most in the array, x or
 * y.
 * If both elements have the same frequency, then return the smaller element.
 * Note: We need to return the element, not its count.
 * 
 */
public class gfg3_whosmajorityfromxandy {
    public static int findMajorityElement(int[] arr, int x, int y) {
        int counter = 0;
        for (int element : arr) {
            if (element == x) {
                counter++;
            } else if (element == y) {
                counter--;
            }
        }

        if (counter > 0) {
            return x;
        } else if (counter < 0) {
            return y;
        } else {
            return Math.min(x, y);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 1, 2, 1 };
        int x = 1;
        int y = 2;
        int result = findMajorityElement(arr, x, y);
        System.out.println("Element with higher frequency: " + result);
    }
}
