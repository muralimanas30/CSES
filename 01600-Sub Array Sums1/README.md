## 📝 **CSES Problem**

| 🔢 Problem Number | 📌 Title                 | 🔗 Link                                           |
| ------------------ | ----------------------- | ------------------------------------------------- |
| 1660               | Subarray Sums I | [CSES Problem](https://cses.fi/problemset/task/1660) |

## 💡 **Problem Explanation**

Given an array of $n$ positive integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**

*   Initialize a sliding window with `left = 0`, `right = 0`, and `currSum = 0`.
*   Iterate through the array using the `right` pointer to expand the window.
*   Add the current element `arr[right]` to `currSum`.
*   While `currSum` is greater than the `target` and `left <= right`, shrink the window by incrementing the `left` pointer and subtracting `arr[left]` from `currSum`.
*   If `currSum` equals the `target`, increment the `count`.
*   Repeat until the `right` pointer reaches the end of the array.

## 🔥 **Code Implementation**

```java
import java.util.*;

public class SubArraySums1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long target = scan.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }

        long currSum = 0;
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > target && left <= right) {
                currSum -= arr[left++];
            }

            if (currSum == target) {
                count++;
            }
        }

        System.out.println(count);
    }
}
```

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** $O(n)$, where $n$ is the number of elements in the array. The `left` and `right` pointers each move at most $n$ times.
*   **Space Complexity:** $O(1)$, as we only use a constant amount of extra space for variables.

