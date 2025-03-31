## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1633 | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

---

## 💡 **Problem Explanation**
Your task is to count the number of ways to construct sum n by throwing a dice one or more times. Each throw produces an outcome between 1 and 6.

For example, if n=3, there are 4 ways:

1+1+1
1+2
2+1
3

Input

The only input line has an integer n.

Output

Print the number of ways modulo 10^9+7.

Constraints

1 \le n \le 10^6

Example

Input:

3

Output:

4

## 📊 **Algorithm**
*   Initialize a DP array `dp` of size `n+1`, where `dp[i]` represents the number of ways to form the sum `i`.
*   The base case is `dp[0] = 1`, as there's one way to form a sum of 0 (doing nothing).
*   Iterate from `i = 1` to `n`:
    *   For each `i`, iterate from `j = max(0, i-6)` to `i-1`:
        *   `dp[i] = (dp[i] + dp[j]) % mod`, where `mod = 10^9 + 7`. This adds the number of ways to reach sum `j` to the number of ways to reach sum `i`.  We are adding `dp[j]` because if we are at the sum `j`, we can roll a dice with value `i - j` to reach the sum `i`. `i - j` will always be between 1 and 6 because `j` varies between `max(0, i - 6)` and `i - 1`.
*   Finally, `dp[n]` will contain the total number of ways to form sum `n`.

## 🔥 **Code Implementation**
```java
import java.util.*;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % mod;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
```

## 🚀 **Time & Space Complexity**
The **time complexity** of this solution is **O(n)** due to the nested loops where the outer loop iterates from 1 to `n` and the inner loop iterates a maximum of 6 times for each `i`.  Thus the overall run time is 6\*n which simplifies to O(n).

The **space complexity** of this solution is **O(n)** because we use a DP array `dp` of size `n+1` to store the intermediate results.
