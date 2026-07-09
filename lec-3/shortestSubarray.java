import java.io.*;
import java.util.*;

class Solution {

    public int shortestSubarray(int[] nums, int K) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();

        int ans = nums.length + 1;

        for (int i = 0; i < prefix.length; i++) {

            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= K) {
                ans = Math.min(ans, i - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return ans == nums.length + 1 ? -1 : ans;
    }
}

public class shortestSubarray {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] first = br.readLine().trim().split("\\s+");

        int N = Integer.parseInt(first[0]);
        int K = Integer.parseInt(first[1]);

        int[] nums = new int[N];

        String[] parts = br.readLine().trim().split("\\s+");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();

        out.println(sol.shortestSubarray(nums, K));

        out.flush();
    }
}