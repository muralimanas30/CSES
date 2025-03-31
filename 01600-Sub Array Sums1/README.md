## 📝 **CSES Problem**

| 🔢 Problem Number | 📌 Title               | 🔗 Link                                      |
| ------------------ | --------------------- | -------------------------------------------- |
| 1660               | Subarray Sums I       | [CSES Problem](https://cses.fi/problemset/task/1660) |

## 💡 **Problem Explanation**

Given an array of $n$ positive integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**

*   Initialize two pointers, `left` and `right`, to 0.
*   Initialize a variable `currSum` to 0 to store the current sum of the subarray.
*   Initialize a variable `count` to 0 to store the number of subarrays with sum equal to the target.
*   Iterate through the array using the `right` pointer:
    *   Add the current element `arr[right]` to `currSum`.
    *   While `currSum` is greater than the target value `x` and `left` is less than or equal to `right`:
        *   Subtract the element at the `left` pointer `arr[left]` from `currSum`.
        *   Increment the `left` pointer.
    *   If `currSum` is equal to the target value `x`:
        *   Increment the `count`.
*   Return the `count`.

## 🔥 **Code Implementation**

```java
import java.util.*;

public class SubarraySumsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
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

*   **Time Complexity:** $O(n)$, because each element in the array is visited at most twice by the `left` and `right` pointers.
*   **Space Complexity:** $O(1)$, because only a fixed number of variables are used, regardless of the input size. The `arr` array occupies $O(n)$ space, but it is considered input space, not auxiliary space.
