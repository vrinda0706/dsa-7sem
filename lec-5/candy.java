import java.util.*;

public class candy {

    public static int candy(int[] nums) {

        int n=nums.length;

        int[] candy=new int[n];
        Arrays.fill(candy,1);

        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])
                candy[i]=candy[i-1]+1;
        }

        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[i+1])
                candy[i]=Math.max(candy[i],candy[i+1]+1);
        }

        int sum=0;

        for(int x:candy)
            sum+=x;

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int ans=candy(nums);

        System.out.println(ans);

        sc.close();
    }
}