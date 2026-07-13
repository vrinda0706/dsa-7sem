import java.util.*;

public class binaryCameras {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {

        int cameras = 0;

        // 0 = Needs Camera
        // 1 = Has Camera
        // 2 = Covered

        private int dfs(TreeNode root) {
            if (root == null)
                return 2;

            int left = dfs(root.left);
            int right = dfs(root.right);

            if (left == 0 || right == 0) {
                cameras++;
                return 1;
            }

            if (left == 1 || right == 1)
                return 2;

            return 0;
        }

        public int minCameraCover(TreeNode root) {
            if (dfs(root) == 0)
                cameras++;

            return cameras;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        String[] tokens = new String[n];

        for (int i = 0; i < n; i++)
            tokens[i] = sc.next();

        if (tokens[0].equals("null")) {
            System.out.println(0);
            return;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int idx = 1;

        while (!queue.isEmpty() && idx < n) {

            TreeNode node = queue.poll();

            if (idx < n && !tokens[idx].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(tokens[idx]));
                queue.add(node.left);
            }
            idx++;

            if (idx < n && !tokens[idx].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(tokens[idx]));
                queue.add(node.right);
            }
            idx++;
        }

        Solution sol = new Solution();
        System.out.println(sol.minCameraCover(root));
    }
}