package greedy_algorithm.medium_hard;

import java.util.ArrayList;
import java.util.Collections;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class Q7_nmeetings {
    public static int assignmeetings(int start[], int end[]) {
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));
        Collections.sort(meet, (a, b) -> a.end - b.end);
        int count = 1;
        int limit = meet.get(0).end;
        for (int i = 1; i < meet.size(); i++) {
            if (meet.get(i).start > limit) {
                count++;
                limit = meet.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 1, 5, 5, 8 };
        int end[] = { 5, 4, 2, 9, 7, 9 };
        System.out.println(assignmeetings(start, end));
    }

}
