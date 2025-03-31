## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1633 | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

---

## 💡 **Problem Explanation**

The problem asks: How many ways can you reach a sum of `n` by throwing a standard six-sided die multiple times? The order of throws matters. Since the answer can be large, compute it modulo $10^9 + 7$.

**Example:**

If `n = 3`, the possible ways are:

*   1 + 1 + 1
*   1 + 2
*   2 + 1
*   3

Therefore, the output should be 4.

If `n = 7`, there are 64 possible ways to obtain sum = 7.

---

## 📊 **Algorithm**

*   Create a DP array `dp` of size `n+1`.  `dp[i]` stores the number of ways to reach the sum `i`.
*   Initialize `dp[0] = 1` because there is one way to reach sum 0 (no throws).
*   Iterate from `i = 1` to `n`.
*   For each `i`, iterate from `j = i-6` to `i-1`.  This represents the last throw (from 1 to 6).
*   If `j >= 0`, then `dp[i] = (dp[i] + dp[j]) % mod`.  This means the number of ways to reach `i` is the sum of ways to reach `j` and then throwing a die with value `i-j`.
*   Return `dp[n]`.

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

N/A, this problem does not have grids or trees.

## 📊 **WORKING**

Let's trace the execution for `n = 4`:

1.  `dp[0] = 1`
2.  `dp[1] = 1`
3.  `i = 2`:  `j` goes from -4 to 1. Valid `j` are 0, 1.
    *   `dp[2] = dp[0] + dp[1] = 1 + 1 = 2`
4.  `i = 3`:  `j` goes from -3 to 2. Valid `j` are 0, 1, 2.
    *   `dp[3] = dp[0] + dp[1] + dp[2] = 1 + 1 + 2 = 4`
5.  `i = 4`:  `j` goes from -2 to 3. Valid `j` are 0, 1, 2, 3.
    *   `dp[4] = dp[0] + dp[1] + dp[2] + dp[3] = 1 + 1 + 2 + 4 = 8`

So the answer is 8.

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** The outer loop runs `n` times, and the inner loop runs at most 6 times. Therefore, the time complexity is **O(n)**.
*   **Space Complexity:** We use an array `dp` of size `n+1`. Therefore, the space complexity is **O(n)**.
