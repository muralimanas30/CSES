## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1633 | Dice Combinations | [CSES Problem](https://cses.fi/problemset/task/1633/) |

---

## 💡 **Problem Explanation**
Your task is to count the number of ways to construct sum *n* by throwing a dice one or more times. Each throw produces an outcome between 1 and 6.

For example, if *n*=3, there are 4 ways:

*   1+1+1
*   1+2
*   2+1
*   3

**Input**

The only input line has an integer *n*.

**Output**

Print the number of ways modulo 10^9+7.

**Constraints**

*   1 ≤ *n* ≤ 10^6

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

*   **Dynamic Programming Approach:** We use dynamic programming to solve this problem. We create an array `dp` of size *n+1* where `dp[i]` stores the number of ways to form the sum *i*.
*   **Base Case:** `dp[0] = 1` because there is one way to form the sum 0 (i.e., no throws).
*   **Iteration:** We iterate from 1 to *n*. For each *i*, we iterate from *i-6* to *i-1*. If *j* is a valid index (i.e., *j* >= 0), we add `dp[j]` to `dp[i]`. The logic behind this is: to reach sum *i*, we can reach it from sum *j* by throwing a dice with a value of *i - j* (which must be between 1 and 6).
*   **Modulo:** We take the modulo of the result at each step to prevent overflow, as the number of ways can be very large.  Modulo value is 10^9 + 7.

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

*   **Time Complexity:** **O(n)** because we have a nested loop, but the inner loop always iterates a maximum of 6 times regardless of *n*, effectively making it constant time.
*   **Space Complexity:** **O(n)** because we use a `dp` array of size *n+1*.
