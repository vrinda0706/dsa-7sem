import java.util.*;
import java.io.*;

public class nikitaQueries {

    static class Solution {

        public List<Integer> specialXor(int N, int Q, int[] a, int[][] query) {

            int xor = 0;
            for (int x : a)
                xor ^= x;

            int[] pre = new int[N + 1];
            for (int i = 1; i <= N; i++)
                pre[i] = pre[i - 1] ^ a[i - 1];

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < Q; i++) {
                int l = query[i][0];
                int r = query[i][1];

                int inside = pre[r] ^ pre[l - 1];
                ans.add(xor ^ inside);
            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken();
        int N = (int) st.nval;

        st.nextToken();
        int Q = (int) st.nval;

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            st.nextToken();
            a[i] = (int) st.nval;
        }

        int[][] query = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st.nextToken();
            query[i][0] = (int) st.nval;
            st.nextToken();
            query[i][1] = (int) st.nval;
        }

        Solution sol = new Solution();
        List<Integer> ans = sol.specialXor(N, Q, a, query);

        StringBuilder sb = new StringBuilder();
        for (int x : ans)
            sb.append(x).append("\n");

        System.out.print(sb);
    }
}