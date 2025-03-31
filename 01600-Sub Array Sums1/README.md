## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1660 | Subarray Sums I | [CSES Problem](https://cses.fi/problemset/task/1660) |

---

## 💡 **Problem Explanation**

Given an array of $n$ integers, find the number of subarrays whose sum equals a given target value $x$.

---

## 📊 **Algorithm**

The algorithm utilizes the sliding window technique to efficiently find all subarrays with the target sum.
*   Initialize variables: `left` pointer (start of window), `currSum` (current sum of the window), and `count` (number of subarrays with target sum).
*   Iterate through the array with a `right` pointer (end of window).
*   Add the element at `right` to `currSum`.
*   While `currSum` exceeds the `target`, shrink the window from the left by incrementing the `left` pointer and subtracting the element at `left` from `currSum`.
*   If `currSum` equals the `target`, increment the `count`.
*   Return the `count`.

## 🔥 **Code Implementation**
```java
import java.util.*;

public class SubarraySums1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        int left = 0;
        long currentSum = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            currentSum += a[right];

            while (currentSum > x && left <= right) {
                currentSum -= a[left];
                left++;
            }

            if (currentSum == x) {
                count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
```

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** **_O(n)_**, where n is the number of elements in the input array, because each element is visited at most twice (once by the right pointer and once by the left pointer).
*   **Space Complexity:** **_O(1)_**, excluding the input array. The algorithm uses only a few extra variables that take constant space.
