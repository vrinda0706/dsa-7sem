
import java.util.*;
import java.io.*;

public class closetSum {
    static class Solution {
        public int closestTripletSum(int[] arr, int target) {
            Arrays.sort(arr);
            int closetSum = arr[0] + arr[1] + arr[2];
            for (int i = 0; i < arr.length - 2; i++) {
                int left = i + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right];
                    if (Math.abs(sum - target) < Math.abs(closetSum - target)) {
                        closetSum = sum;
                    } else if (Math.abs(sum - target) == Math.abs(closetSum - target) && sum > closetSum) {
                        closetSum = sum;
                    }
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        return sum;
                    }
                }
            }
            return closetSum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken(); int n = (int) st.nval;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            arr[i] = (int) st.nval;
        }

        st.nextToken(); int target = (int) st.nval;

        Solution sol = new Solution();
        System.out.println(sol.closestTripletSum(arr, target));
    }
}