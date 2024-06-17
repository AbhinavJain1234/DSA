package string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Time Complexity:
Counting frequencies: O(n)
Sorting the list: O(klogk), which is O(1) due to the constant maximum of 26 unique characters.
Building the result string: O(n)
Overall: O(n)

Space Complexity:
The HashMap requires O(k) space, which is O(1) since k is at most 26.
The list of entries and the result string require O(n) space.
Overall: O(n)
*/

public class Q1_sortbyfrequency {
    class Pair {
        char letter;
        int count;

        Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            for (int i = 0; i < pair.count; i++) {
                result.append(pair.letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Q1_sortbyfrequency obj = new Q1_sortbyfrequency();
        System.out.println(obj.frequencySort("tree"));
    }
}
