package recursion.kunal.arrays;

public class binarysearchinrotated {
    public static int search(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target < arr[mid]) {
                return search(arr, start, mid - 1, target);
            } else {
                return search(arr, mid + 1, end, target);
            }
        } else {
            if (target > arr[mid] && target <= arr[end]) {
                return search(arr, mid + 1, end, target);
            } else {
                return search(arr, start, mid - 1, target);
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(arr, 0, arr.length - 1, 0));
    }

}
