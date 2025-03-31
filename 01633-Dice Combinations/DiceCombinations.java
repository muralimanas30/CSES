import java.util.*;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 6; j < i; j++)
                if (j >= 0)
                    dp[i] = (dp[i] + dp[j]) % mod;
        }
        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]%mod);
    }
}