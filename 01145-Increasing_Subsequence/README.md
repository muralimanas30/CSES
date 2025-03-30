## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**

The problem asks you to find the length of the longest increasing subsequence in a given array of numbers. A subsequence doesn't have to be contiguous, meaning the elements don't have to be next to each other in the original array.  An increasing subsequence is a sequence where each element is greater than the element before it.

For example:

Input: `[3, 2, 6, 4, 5, 1]`

Output: `3` (One possible longest increasing subsequence is `[2, 4, 5]`)

---

## 📊 **Algorithm**

*   Initialize an empty `ArrayList` called `req`.
*   Add the first element of the input array `arr` to `req`.
*   Iterate through the rest of the input array `arr` from the second element.
    *   If the current element of `arr` is greater than the last element of `req`, add it to `req`.
    *   Otherwise, find the smallest element in `req` that is greater than or equal to the current element of `arr` using binary search, and replace that element with the current element of `arr`.
*   The size of `req` is the length of the longest increasing subsequence.

## 🔥 **Code Implementation**

```java
import java.util.*;

class IncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextLong();
        }
        ArrayList<Long> req = new ArrayList<>();
        int endIndex = 0;
        req.add(arr[0]);
        for(int i=1; i < n ; i++){
            if( arr[i] > req.get(endIndex) ){
                req.add(arr[i]);
                endIndex++;
            }
            else{
                int replaceIndex = Collections.binarySearch(req,arr[i]);
                if(replaceIndex<0){
                    replaceIndex = -(replaceIndex+1);
                }
                req.set(replaceIndex,arr[i]);
            }
        }
        System.out.println(req.size());
    }
}
```

## 📊 **ASCII Representation**

This problem doesn't directly involve grids or trees, so an ASCII representation isn't the most helpful way to visualize it. However, you can think of it as transforming the `req` list at each step.

## 📊 **WORKING**

Let's trace the execution with the sample input: `[3, 2, 6, 4, 5, 1]`

1.  `arr = [3, 2, 6, 4, 5, 1]`
2.  `req = [3]` (Initialize `req` with the first element)
3.  `i = 1`, `arr[1] = 2`.  `2 < 3`. Binary search finds the index to replace (0). `req = [2]`
4.  `i = 2`, `arr[2] = 6`.  `6 > 2`.  `req = [2, 6]`
5.  `i = 3`, `arr[3] = 4`.  `4 < 6`. Binary search finds the index to replace (1). `req = [2, 4]`
6.  `i = 4`, `arr[4] = 5`.  `5 > 4`.  `req = [2, 4, 5]`
7.  `i = 5`, `arr[5] = 1`.  `1 < 5`. Binary search finds the index to replace (0). `req = [1, 4, 5]`

Finally, the size of `req` is 3, which is the length of the longest increasing subsequence. Note that the `req` array doesn't necessarily contain the LIS itself, but only helps in computing the length of the LIS.

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** **O(n log n)**, where n is the length of the input array. This is because the code iterates through the array once (O(n)), and inside the loop, it performs a binary search on the `req` array (O(log n)).
*   **Space Complexity:** **O(n)**, in the worst case, the `req` array can store all the elements of the input array. For example, if the input array is already sorted in increasing order, `req` will store all the elements.
