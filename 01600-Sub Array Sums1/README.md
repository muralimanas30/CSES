## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1660 | Subarray Sums I | [CSES Problem](https://cses.fi/problemset/task/1660) |

---

## 💡 **Problem Explanation**

Given an array of $n$ positive integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**

This problem can be efficiently solved using the two-pointer (sliding window) technique. Here's the algorithm:

*   Initialize two pointers, `left` and `right`, to 0.
*   Initialize a variable `currSum` to 0, representing the current sum of the subarray from `left` to `right`.
*   Initialize a variable `count` to 0, representing the number of subarrays with sum equal to $x$.
*   Iterate the `right` pointer from 0 to $n-1$:
    *   Add the element at the `right` index to `currSum`.
    *   While `currSum` is greater than the target value $x$ and `left` is less than or equal to `right`:
        *   Subtract the element at the `left` index from `currSum`.
        *   Increment the `left` pointer.
    *   If `currSum` is equal to the target value $x$, increment the `count`.
*   Return the `count`.

## 🔥 **Code Implementation**

```java
import java.util.*;

public class SubarraySums1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int left = 0;
        long currSum = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > x && left <= right) {
                currSum -= arr[left];
                left++;
            }

            if (currSum == x) {
                count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
```

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** $O(n)$, because both `left` and `right` pointers iterate through the array at most once.
*   **Space Complexity:** $O(1)$, as we are only using a few constant space variables. The input array `arr` is already given, so it's not considered extra space used by the algorithm.
