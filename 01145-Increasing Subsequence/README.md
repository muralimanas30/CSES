## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**
You are given an array containing \(n\) integers. Your task is to determine the longest increasing subsequence in the array, i.e., the longest subsequence where every element is larger than the previous one.

A subsequence is a sequence that can be derived from the array by deleting some elements without changing the order of the remaining elements.

**Input**

The first line contains an integer \(n\): the size of the array.

After this there are \(n\) integers \(x_1,x_2,\ldots,x_n\): the contents of the array.

**Output**

Print the length of the longest increasing subsequence.

## 📊 **Algorithm**
*   Initialize an empty `ArrayList` called `req` to store the increasing subsequence.
*   Add the first element of the input array `arr` to `req`.
*   Iterate through the remaining elements of `arr` from the second element.
    *   If the current element `arr[i]` is greater than the last element of `req`, add `arr[i]` to the end of `req`.
    *   Otherwise, use binary search to find the smallest element in `req` that is greater than or equal to `arr[i]` and replace it with `arr[i]`.
*   After iterating through all elements of `arr`, the size of `req` will be the length of the longest increasing subsequence.
*   Print the size of `req`.

## 🔥 **Code Implementation**
```java
import java.util.*;
 
public class IncreasingSubsequence {
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

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** **O(n log n)**, where n is the size of the input array. This is because the algorithm iterates through the array once (O(n)), and in each iteration, it performs a binary search on the `ArrayList` `req` (O(log n)).

*   **Space Complexity:** **O(n)** in the worst case, where n is the size of the input array. This is because the `ArrayList` `req` can potentially store all elements of the input array if the array is strictly increasing.
