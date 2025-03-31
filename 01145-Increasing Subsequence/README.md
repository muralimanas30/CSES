## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**
You are given an array containing \(n\) integers. Your task is to determine the longest increasing subsequence in the array, i.e., the longest subsequence where every element is larger than the previous one.

A subsequence is a sequence that can be derived from the array by deleting some elements without changing the order of the remaining elements.

## 📊 **Algorithm**

*   Initialize an empty ArrayList `req` to store the increasing subsequence found so far.
*   Iterate through the input array `arr` from left to right.
*   If the current element `arr[i]` is greater than the last element of `req`, it extends the longest increasing subsequence found so far. Therefore, append `arr[i]` to `req`.
*   Otherwise, find the smallest element in `req` that is greater than or equal to `arr[i]` using binary search.  Replace that element with `arr[i]`. This ensures that `req` always maintains an increasing order and stores the smallest end elements for subsequences of different lengths.
*   After iterating through the entire input array, the size of `req` is the length of the longest increasing subsequence.

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

*   **Time Complexity:** The outer loop iterates through the array of size \(n\), and inside the loop, `Collections.binarySearch` takes \(O(\log n)\) time. Therefore, the overall time complexity is **\(O(n \log n)\)**.
*   **Space Complexity:** The `req` ArrayList stores the increasing subsequence. In the worst-case scenario (when the input array is already sorted in increasing order), `req` will store all \(n\) elements. Therefore, the space complexity is **\(O(n)\)**.
