import java.util.Random;

public class yesorno {
    public static void main(String[] args) {
        callYesOrNoMultipleTimes();
    }
    public static void callYesOrNoMultipleTimes() {
        for (int i = 0; i < 11; i++) {
            System.out.println("Call #" + (i + 1));
            callYesOrNoOnce();
            System.out.println();
        }
    }
    public static void callYesOrNoOnce() {
        int n = 100000;
        Random random = new Random();

        int yesCount = 0;
        int noCount = 0;
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(2); 
            if (randomNumber == 0) {
            noCount++;
            } else {
            yesCount++;
            }
        }

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("...");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("And the answer is...");

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (yesCount > noCount) {
            System.out.println("Shave");
        } else {
            System.out.println("DON'T Shave");
        }
    }
}
