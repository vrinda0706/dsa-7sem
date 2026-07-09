import java.util.*;
import java.io.*;

public class IterativePostorder {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {

        public List<Integer> postorderTraversal(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();
            LinkedList<Integer> ans = new LinkedList<>();

            if (root == null)
                return ans;

            stack.push(root);

            while (!stack.isEmpty()) {

                TreeNode curr = stack.pop();

                ans.addFirst(curr.val);

                if (curr.left != null)
                    stack.push(curr.left);

                if (curr.right != null)
                    stack.push(curr.right);
            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        if (line == null || line.trim().isEmpty()) {
            System.out.println();
            return;
        }

        String[] tokens = line.trim().split("\\s+");

        if (tokens.length == 0 || tokens[0].equals("N")) {
            System.out.println();
            return;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < tokens.length) {

            TreeNode node = queue.poll();

            if (i < tokens.length && !tokens[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(node.left);
            }

            i++;

            if (i < tokens.length && !tokens[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(node.right);
            }

            i++;
        }

        Solution sol = new Solution();

        List<Integer> result = sol.postorderTraversal(root);

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < result.size(); j++) {
            if (j > 0)
                sb.append(" ");
            sb.append(result.get(j));
        }

        System.out.println(sb.toString());
    }
}