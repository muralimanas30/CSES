## 📝 **CSES Problem**

| 🔢 Problem Number | 📌 Title            | 🔗 Link                                    |
| :---------------- | :----------------- | :------------------------------------------ |
| 1633              | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

## 💡 **Problem Explanation**

Imagine you're rolling a standard six-sided die. You want to find out how many different ways you can reach a target sum `n` by rolling the die multiple times. Each roll contributes its face value (1 to 6) to the total sum. The order of the rolls matters, meaning that rolling a 1 then a 2 is different from rolling a 2 then a 1.

**Example:**

If `n = 3`, the possible ways are:

*   1 + 1 + 1
*   1 + 2
*   2 + 1
*   3

So, the answer would be 4.  Since the answer may be large, compute the answer modulo $10^9 + 7$.

**Sample Input:**

```
3
```

**Sample Output:**

```
4
```

## 📊 **Algorithm**

*   Create a DP array `dp` of size `n+1` to store the number of ways to reach each sum from 0 to `n`.
*   Initialize `dp[0] = 1` because there is one way to reach a sum of 0 (doing nothing).
*   Iterate from `i = 1` to `n`:
    *   For each `i`, iterate from `j = i-6` to `i-1`:
        *   If `j >= 0`, it means we can reach sum `i` from sum `j` by rolling the die.
        *   Add `dp[j]` to `dp[i]` and take modulo `1000000007` to prevent overflow.
*   Finally, `dp[n]` will contain the total number of ways to reach the sum `n`.

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

Not applicable, as this problem doesn't involve grids, trees, or movements.

## 📊 **WORKING**

Let's trace the execution for `n = 4`.  `mod = 1000000007`.

1.  `dp` is initialized as `[1, 1, 0, 0, 0]`

2.  `i = 2`: The inner loop iterates from `j = -4` to `1`.

    *   `j = -4`: `j < 0`, so skip.
    *   `j = -3`: `j < 0`, so skip.
    *   `j = -2`: `j < 0`, so skip.
    *   `j = -1`: `j < 0`, so skip.
    *   `j = 0`: `dp[2] = (dp[2] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[2] = (dp[2] + dp[1]) % mod = (1 + 1) % mod = 2`

    `dp` becomes `[1, 1, 2, 0, 0]`

3.  `i = 3`: The inner loop iterates from `j = -3` to `2`.

    *   `j < 0`: skip
    *   `j = 0`: `dp[3] = (dp[3] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[3] = (dp[3] + dp[1]) % mod = (1 + 1) % mod = 2`
    *   `j = 2`: `dp[3] = (dp[3] + dp[2]) % mod = (2 + 2) % mod = 4`

    `dp` becomes `[1, 1, 2, 4, 0]`

4.  `i = 4`: The inner loop iterates from `j = -2` to `3`.

    *   `j < 0`: skip
    *   `j = 0`: `dp[4] = (dp[4] + dp[0]) % mod = (0 + 1) % mod = 1`
    *   `j = 1`: `dp[4] = (dp[4] + dp[1]) % mod = (1 + 1) % mod = 2`
    *   `j = 2`: `dp[4] = (dp[4] + dp[2]) % mod = (2 + 2) % mod = 4`
    *   `j = 3`: `dp[4] = (dp[4] + dp[3]) % mod = (4 + 4) % mod = 8`

    `dp` becomes `[1, 1, 2, 4, 8]`

Finally, `dp[4]` is 8, which is the answer.

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** The outer loop runs `n` times, and the inner loop runs at most 6 times. Therefore, the time complexity is **O(n)**.
*   **Space Complexity:** We use an array `dp` of size `n+1` to store the number of ways to reach each sum. Thus, the space complexity is **O(n)**.
