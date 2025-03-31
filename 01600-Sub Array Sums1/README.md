## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1660 | Subarray Sums I | [CSES Problem](https://cses.fi/problemset/task/1660) |

---

## 💡 **Problem Explanation**

Given an array of $n$ integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**

The problem can be solved efficiently using the sliding window technique. The main idea is to maintain a window (subarray) and adjust its boundaries (left and right pointers) to find subarrays that meet the given condition.

*   Initialize the left and right pointers to 0, the current sum to 0, and the count to 0.
*   Iterate through the array with the right pointer.
*   Add the current element to the current sum.
*   While the current sum is greater than the target, shrink the window from the left by removing elements from the left side until the sum is less than or equal to the target.
*   If the current sum equals the target, increment the count.
*   Repeat steps 2-5 until the right pointer reaches the end of the array.
*   Return the count.

## 🔥 **Code Implementation**

```java
import java.util.*;

public class SubarraySums1 {
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

*   **Time Complexity:** The algorithm iterates through the array once with the right pointer, and the left pointer also moves at most $n$ times. Therefore, the time complexity is **O(n)**.

*   **Space Complexity:** The algorithm uses a fixed amount of extra space for variables like `currSum`, `left`, `count`, etc. The array `arr` stores the input, but this is considered the input space. Hence, the space complexity is **O(1)**, indicating constant extra space.
