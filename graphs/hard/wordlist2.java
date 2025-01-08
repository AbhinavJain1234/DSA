package graphs.hard;

import java.util.*;

public class wordlist2 {
    public List<List<String>> findSequences(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        List<List<String>> ans = new ArrayList<>();
        q.add(new ArrayList<>(Arrays.asList(beginWord)));
        Set<String> st = new HashSet<>(wordList);
        Set<String> toErase = new HashSet<>();
        if (!st.contains(endWord)) return ans; 

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<String> seq = q.poll();
                String word = seq.get(seq.size() - 1);

                if (word.equals(endWord)) {
                    if (ans.isEmpty() || seq.size() == ans.get(0).size()) {
                        ans.add(new ArrayList<>(seq));
                    }
                }
                for (int pos = 0; pos < word.length(); pos++) {
                    char original = word.charAt(pos);
                    char[] wordArray = word.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordArray[pos] = ch;
                        String newWord = new String(wordArray);

                        if (st.contains(newWord)) {
                            seq.add(newWord);
                            q.add(new ArrayList<>(seq));
                            toErase.add(newWord); 
                            seq.remove(seq.size() - 1); 
                        }
                    }
                }
            }
            for (String word : toErase) {
                st.remove(word);
            }
            toErase.clear();

            if (!ans.isEmpty()) break;
        }
        return ans;
    }
}
