## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1145 | Increasing Subsequence | [CSES Problem](https://cses.fi/problemset/task/1145/) |

---

## 💡 **Problem Explanation**
You are given an array containing \(n\) integers. Your task is to determine the longest increasing subsequence in the array, i.e., the longest subsequence where every element is larger than the previous one.

A subsequence is a sequence that can be derived from the array by deleting some elements without changing the order of the remaining elements.

## 📊 **Algorithm**
*   Initialize an `ArrayList` called `req` to store the increasing subsequence.
*   Add the first element of the input array to `req`.
*   Iterate through the input array starting from the second element:
    *   If the current element is greater than the last element in `req`, append it to `req`.
    *   Otherwise, perform a binary search in `req` to find the smallest element greater than or equal to the current element and replace it with the current element.
*   The size of `req` at the end represents the length of the longest increasing subsequence.

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

*   **Time Complexity:** The algorithm uses a loop that iterates `n` times. Inside the loop, `Collections.binarySearch` is called, which has a time complexity of **O(log n)**. Therefore, the overall time complexity is **O(n log n)**.

*   **Space Complexity:** An `ArrayList` called `req` is used to store the longest increasing subsequence found so far. In the worst case, the entire input array could be an increasing subsequence, so the space complexity is **O(n)**.
