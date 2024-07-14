package recursion.kunal.basic;

public class palindrome {
    public static boolean isPalindrome(int n) {
        return n == reverse.reversee(n);
    }

    public static void main(String[] args) {
        int n = 12321; // Change this to the desired value
        System.out.println(isPalindrome(n));
    }

}
