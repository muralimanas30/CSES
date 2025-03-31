## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1633 | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

---

## 💡 **Problem Explanation**

The problem asks us to find the number of ways to form a sum `n` by throwing a standard six-sided die multiple times. Each throw results in a value from 1 to 6, and we need to find the total number of distinct combinations that add up to `n`. Since the number of combinations can be very large, we need to output the result modulo $10^9 + 7$.

## 📊 **Algorithm**

Here's the algorithm implemented in the provided Java code:

*   Initialize a `dp` array of size `n + 1` to store the number of ways to reach each sum from 0 to `n`.
*   Set `dp[0] = 1`, representing that there is one way to reach a sum of 0 (by not throwing the die at all).
*   Set `dp[1] = 1`, representing that there is one way to reach a sum of 1.
*   Iterate from `i = 2` to `n` to fill in the `dp` array.
*   For each `i`, iterate from `j = i - 6` to `i - 1`.
*   If `j` is a valid index (i.e., `j >= 0`), add `dp[j]` to `dp[i]` modulo $10^9 + 7$. This represents adding the number of ways to reach the sum `j` to the number of ways to reach the sum `i` by throwing a die value of `i - j`.
*   Finally, print `dp[n] % mod`, which contains the total number of ways to reach the sum `n`.

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
```

## 📊 **ASCII Representation**

This problem doesn't involve grids or trees, so an ASCII representation is not directly applicable. However, we can visualize the `dp` array's progression for a small input.

## 📊 **WORKING**

Let's trace the execution for `n = 4`. The `mod` is $10^9 + 7$.

1.  `dp[0] = 1`
2.  `dp[1] = 1`
3.  `i = 2`:
    *   `j` ranges from `2 - 6 = -4` to `2 - 1 = 1`.
    *   `j = 0`: `dp[2] = (dp[2] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[2] = (dp[2] + dp[1]) % mod = (1 + 1) % mod = 2`
4.  `i = 3`:
    *   `j` ranges from `3 - 6 = -3` to `3 - 1 = 2`.
    *   `j = 0`: `dp[3] = (dp[3] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[3] = (dp[3] + dp[1]) % mod = (1 + 1) % mod = 2`
    *   `j = 2`: `dp[3] = (dp[3] + dp[2]) % mod = (2 + 2) % mod = 4`
5.  `i = 4`:
    *   `j` ranges from `4 - 6 = -2` to `4 - 1 = 3`.
    *   `j = 0`: `dp[4] = (dp[4] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[4] = (dp[4] + dp[1]) % mod = (1 + 1) % mod = 2`
    *   `j = 2`: `dp[4] = (dp[4] + dp[2]) % mod = (2 + 2) % mod = 4`
    *   `j = 3`: `dp[4] = (dp[4] + dp[3]) % mod = (4 + 4) % mod = 8`

Finally, `dp[4] = 8`.

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** The outer loop runs from `2` to `n`, and the inner loop runs at most 6 times for each value of `i`. Thus, the time complexity is **O(n)**.
*   **Space Complexity:** The `dp` array stores `n + 1` long integers, so the space complexity is **O(n)**.
