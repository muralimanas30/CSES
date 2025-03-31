## 📝 **CSES Problem**

| 🔢 Problem Number | 📌 Title           | 🔗 Link                                      |
| ------------------ | ----------------- | -------------------------------------------- |
| 1633              | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

---

## 💡 **Problem Explanation**

Your task is to count the number of ways to construct a sum `n` by throwing a dice one or more times. Each throw produces an outcome between `1` and `6`.

For example, if `n=3`, there are `4` ways:

*   `1+1+1`
*   `1+2`
*   `2+1`
*   `3`

**Input**

The only input line has an integer `n`.

**Output**

Print the number of ways modulo `10^9+7`.

**Constraints**

*   `1 \le n \le 10^6`

**Example**

Input:

```
3
```

Output:

```
4
```

## 📊 **Algorithm**

The problem can be solved using dynamic programming.

*   Initialize a DP array `dp` of size `n+1`, where `dp[i]` stores the number of ways to achieve sum `i`.
*   Base case: `dp[0] = 1` (representing no throws, achieving sum 0).
*   Iterate from `i = 1` to `n`:
    *   For each `i`, iterate through possible dice outcomes `j` from `1` to `6`.
    *   If `i - j >= 0`, then `dp[i] = (dp[i] + dp[i - j]) % (10^9 + 7)`.  This means we can reach `i` by adding outcome `j` to a previous sum `i - j`.
*   The final answer is `dp[n]`.

## 🔥 **Code Implementation**

```java
import java.util.Scanner;

public class DiceCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
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
        scanner.close();
    }
}
```

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** **O(n)** because we iterate from `1` to `n` and then have an inner loop that runs at most 6 times.
*   **Space Complexity:** **O(n)** due to the `dp` array of size `n+1`.
