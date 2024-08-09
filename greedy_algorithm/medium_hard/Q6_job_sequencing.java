package greedy_algorithm.medium_hard;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Q6_job_sequencing {
    public static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int result[] = new int[maxi + 1];

        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {

                // Free slot found
                if (result[j] == -1) {
                    result[j] = arr[i].id;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));

        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;

    }

    public static void main(String[] args) {
        Job arr[] = new Job[5];
        arr[0] = new Job(1, 2, 100);
        arr[1] = new Job(2, 1, 19);
        arr[2] = new Job(3, 2, 27);
        arr[3] = new Job(4, 1, 25);
        arr[4] = new Job(5, 3, 15);

        int n = arr.length;

        int ans[] = JobScheduling(arr, n);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
