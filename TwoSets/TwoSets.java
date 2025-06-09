import java.util.*;
public class TwoSets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = (n*(n+1))/2;
        if((sum&1)==1){
            System.out.println("NO");
            return;
        }  
        sum/=2;
        // int[] temp = new int[sum+1];
        // for(int i=0;i<=sum;i++) temp[i]=i;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] += dp[i-1][j] + ((j-i>=0)?dp[i-1][j-i]:0);
            }
        }
        StringBuilder summing = new StringBuilder();
        StringBuilder compli = new StringBuilder();
        int counter =0;
        while(n>0){
            if(sum>=n && dp[n-1][sum-n]>0){
                summing.append(n+" ");
                sum-=n;
                counter++;
            }
            else
                compli.append(n+" ");
            n--;
        }
 
        // System.out.println(0+" "+Arrays.toString(temp));
        // for(int i=0;i<dp.length;i++)   System.out.println(i+" "+Arrays.toString(dp[i]));
        System.out.println(dp[sum][sum]>0?"YES":"NO");
        System.out.println(counter);
        System.out.println(summing.toString());
        System.out.println(dp.length-1-counter);
        System.out.println(compli.toString());
    }    
}