## 📝 **CSES Problem**

| 🔢 Problem Number | 📌 Title             | 🔗 Link                                  |
| ------------------ | ------------------- | ----------------------------------------- |
| 1660               | Subarray Sums I     | [CSES Problem](https://cses.fi/problemset/task/1660) |

## 💡 **Problem Explanation**

Given an array of $n$ positive integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**

*   Use the sliding window technique.
*   Maintain a `currSum` variable to store the sum of the current window.
*   Maintain `left` and `right` pointers to define the window.
*   Iterate through the array using the `right` pointer, expanding the window.
*   If `currSum` exceeds the target, shrink the window from the left until `currSum` is less than or equal to the target.
*   If `currSum` equals the target, increment the count of subarrays.

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

*   **Time Complexity:** $O(n)$, since we iterate through the array at most twice (once with the `right` pointer and at most once with the `left` pointer).

*   **Space Complexity:** $O(1)$, as we only use a constant amount of extra space for variables like `currSum`, `left`, and `count`. The space used by the input array `arr` is not considered extra space.
