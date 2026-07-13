import java.util.*;

public class jumpGame {

    public static int minJumps(int[] nums) {

        if(nums.length<=1) return 0;

        int jumps=0;
        int end=0;
        int far=0;

        for(int i=0;i<nums.length-1;i++){
            far=Math.max(far,i+nums[i]);
            if(i==end){
                jumps++;
                end=far;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int ans=minJumps(nums);

        System.out.println(ans);

        sc.close();
    }
}