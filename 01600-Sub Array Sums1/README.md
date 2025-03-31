## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1660 | Subarray Sums I | [CSES Problem](https://cses.fi/problemset/task/1660) |

---

## 💡 **Problem Explanation**
Given an array of $n$ integers, find the number of subarrays whose sum equals a given target value $x$.

## 📊 **Algorithm**
1.  Initialize a `currSum` variable to 0, `left` pointer to 0, and `count` to 0.
2.  Iterate through the array using a `right` pointer.
3.  Add the current element `arr[right]` to `currSum`.
4.  While `currSum` is greater than the `target` and `left` is less than or equal to `right`:
    *   Subtract `arr[left]` from `currSum` and increment `left`.
5.  If `currSum` is equal to the `target`, increment `count`.
6.  Return the final `count`.

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
The time complexity is **O(n)** because we are iterating through the array once with the `right` pointer, and the `left` pointer also moves from left to right at most once. Therefore, each element is visited at most twice.
The space complexity is **O(1)** because we are only using a few extra variables that take up constant space, regardless of the input size. The `arr` takes O(n) but that is for the given input and not for extra space.
