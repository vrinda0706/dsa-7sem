import java.util.*;

public class rottenOranges {

    public static int count(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty() && fresh>0){

            int size=q.size();
            time++;

            while(size-->0){

                int[] cur=q.poll();

                for(int k=0;k<4;k++){

                    int nr=cur[0]+dr[k];
                    int nc=cur[1]+dc[k];

                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1){

                        grid[nr][nc]=2;
                        fresh--;

                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return fresh==0?time:-1;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] grid=new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                grid[i][j]=sc.nextInt();

        System.out.println(count(grid));
    }
}