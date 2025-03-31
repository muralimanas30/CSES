## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**
You are given an array containing $n$ integers. Your task is to determine the length of the longest increasing subsequence in the array, i.e., the longest subsequence where every element is larger than the previous one.

A subsequence is a sequence that can be derived from the array by deleting some elements without changing the order of the remaining elements.

## 📊 **Algorithm**

The algorithm utilizes a dynamic programming approach coupled with binary search to efficiently determine the length of the longest increasing subsequence.

*   **Initialization:** Create an empty `ArrayList` called `req`. This list will store the smallest end element of an increasing subsequence of a given length.

*   **First Element:** Add the first element of the input array to the `req` list.

*   **Iteration:** Iterate through the remaining elements of the input array.

    *   **Case 1: Element Extends the Longest Subsequence:** If the current element `arr[i]` is greater than the last element in the `req` list, it extends the current longest increasing subsequence. Add `arr[i]` to the end of the `req` list.

    *   **Case 2: Element Potentially Improves a Subsequence:** If the current element `arr[i]` is not greater than the last element in the `req` list, it means `arr[i]` can potentially replace an existing element in `req` to form a better (shorter end element) increasing subsequence of the same length.
        *   Perform a binary search on `req` to find the smallest element that is greater than or equal to `arr[i]`.
        *   Replace that element with `arr[i]`. This ensures that `req` always contains the smallest end elements for increasing subsequences of different lengths.

*   **Result:** After iterating through all the elements in the input array, the size of the `req` list will be the length of the longest increasing subsequence. Return the size of `req`.

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

*   **Time Complexity:** The algorithm iterates through the input array once, which takes $O(n)$ time. Inside the loop, a binary search is performed on the `req` list, which takes $O(\log n)$ time. Therefore, the overall time complexity of the algorithm is **$O(n \log n)$**.

*   **Space Complexity:** The `req` list stores at most $n$ elements. Thus, the space complexity is **$O(n)$**.
