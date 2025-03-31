## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**
You are given an array containing \(n\) integers. Your task is to determine the longest increasing subsequence in the array, i.e., the longest subsequence where every element is larger than the previous one.

A subsequence is a sequence that can be derived from the array by deleting some elements without changing the order of the remaining elements.

The first line contains an integer \(n\): the size of the array.

After this there are \(n\) integers \(x_1,x_2,\ldots,x_n\): the contents of the array.

Print the length of the longest increasing subsequence.

## 📊 **Algorithm**
*   Initialize an empty list `req` to store the elements of the increasing subsequence.
*   Iterate through the input array `arr`.
*   If the current element `arr[i]` is greater than the last element of `req`, append `arr[i]` to `req`.
*   Otherwise, use binary search to find the smallest element in `req` that is greater than or equal to `arr[i]` and replace it with `arr[i]`.  This ensures that `req` always maintains an increasing order and its length represents the longest increasing subsequence seen so far.
*   After iterating through the entire input array, the size of `req` will be the length of the longest increasing subsequence.

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

*   **Time Complexity:**  **O(n log n)**, where _n_ is the size of the input array. This is due to the `Collections.binarySearch` operation within the loop, which takes O(log n) time and is performed n times.

*   **Space Complexity:** **O(n)**, where _n_ is the size of the input array.  In the worst-case scenario (e.g., a strictly increasing input array), the `req` list will store all _n_ elements.
