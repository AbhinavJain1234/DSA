package string.easy;

public class Q2_reverseword {
    // using string
    public static String reverseWordsStrign(String s) {
        String word = "";
        String finaal = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word.isEmpty()) {
                    continue;
                } else
                    finaal = word + " " + finaal;
                word = "";
            } else {
                word = word + s.charAt(i);
            }
        }
        if (!word.isEmpty())
            finaal = word + " " + finaal;
        finaal = finaal.substring(0, finaal.length() - 1);
        return finaal;
    }

    // using string bulder
    public static String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder finalResult = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (word.length() == 0) {
                    continue;
                } else {
                    // Append word to finalResult with a leading space
                    if (finalResult.length() > 0) {
                        finalResult.insert(0, ' ');
                    }
                    finalResult.insert(0, word);
                    word.setLength(0); // Clear the word StringBuilder
                }
            } else {
                word.append(s.charAt(i));
            }
        }

        // Append the last word (if any) to finalResult
        if (word.length() > 0) {
            if (finalResult.length() > 0) {
                finalResult.insert(0, ' ');
            }
            finalResult.insert(0, word);
        }

        return finalResult.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
