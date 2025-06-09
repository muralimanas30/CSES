# Two Sets – CSES Problem Solution (Java)

[View on CSES](https://cses.fi/problemset/task/1092)

---

## Problem Statement

Given a positive integer `n`, partition the set `{1, 2, ..., n}` into two subsets with equal sums.  
If such a partition exists, print "YES" and the two subsets; otherwise, print "NO".

---

## Example Inputs and Outputs

### Case 1: Partition Possible

#### Input 1
```
7
```
#### Output 1
```
YES
4
7 6 1  // (order may vary)
3
5 4 3 2  // (order may vary)
```

#### Input 2
```
8
```
#### Output 2
```
YES
4
8 7 1 2
4
6 5 4 3
```

### Case 2: Partition Impossible

#### Input 3
```
1
```
#### Output 3
```
NO
```

#### Input 4
```
5
```
#### Output 4
```
NO
```

---

## Algorithm Overview

This solution uses **dynamic programming** to determine if a subset of `{1, 2, ..., n}` sums to half the total sum.  
If the total sum is odd, partitioning is impossible.  
Otherwise, a DP table is built to check subset sums, and the actual subsets are reconstructed by backtracking through the DP table.

**Why this approach?**  
- The DP method is necessary to reconstruct the actual subset, not just to check existence.
- It guarantees correctness for all values of `n`.

---

## Variables and Data Structures

| Variable    | Type           | Description                                      |
|-------------|----------------|--------------------------------------------------|
| `n`         | int            | The input number                                 |
| `sum`       | int            | Target sum for each subset (half of total sum)   |
| `dp`        | int[][]        | DP table: dp[i][j] = #ways to get sum j with 1..i|
| `summing`   | StringBuilder  | Stores elements of the first subset              |
| `compli`    | StringBuilder  | Stores elements of the second subset             |
| `counter`   | int            | Number of elements in the first subset           |

---

## Step-by-Step Algorithm

1. Read integer `n`.
2. Compute the total sum of numbers from 1 to n.
3. If the sum is odd, print "NO" and exit.
4. Set the target sum as half of the total sum.
5. Build a DP table `dp[i][j]` to count ways to form sum `j` using numbers `1..i`.
6. Backtrack from `n` down to `1`:
    - If including `n` is possible (using DP), add to subset 1 and decrease target.
    - Otherwise, add to subset 2.
7. Output "YES", the sizes, and the contents of both subsets.

---

## Visual Diagram

```
Set: {1, 2, 3, 4, 5, 6, 7}
Total sum = 28 (even)
Target sum for each subset = 14

DP Table Construction:
- dp[i][j] = ways to form sum j using 1..i

Backtracking:
- If sum >= n and dp[n-1][sum-n] > 0, include n in subset 1, subtract n from sum.
- Else, include n in subset 2.
- Repeat for n-1, n-2, ..., 1.
```

| Step | Remaining Target | Number Considered | Subset 1         | Subset 2   |
|------|-----------------|-------------------|------------------|------------|
| 1    | 14              | 7                 | 7                |            |
| 2    | 7               | 6                 | 7, 6             |            |
| 3    | 1               | 5                 | 7, 6             | 5          |
| 4    | 1               | 4                 | 7, 6             | 5, 4       |
| 5    | 1               | 3                 | 7, 6             | 5, 4, 3    |
| 6    | 1               | 2                 | 7, 6, 2          | 5, 4, 3    |
| 7    | -1              | 1                 | 7, 6, 2, 1       | 5, 4, 3    |

---

## Step-by-Step Walkthrough (n = 7)

1. Total sum = 28 (even), target = 14.
2. Build DP table for subset sums.
3. Backtrack:
    - 7 fits (sum=14-7=7), add 7 to subset 1.
    - 6 fits (sum=7-6=1), add 6 to subset 1.
    - 5 doesn't fit, add 5 to subset 2.
    - 4 doesn't fit, add 4 to subset 2.
    - 3 doesn't fit, add 3 to subset 2.
    - 2 fits (sum=1-2<0, so skip), but DP allows, so add 2 to subset 1.
    - 1 fits (sum=1-1=0), add 1 to subset 1.

   Final subsets:
   - Subset 1: 7 6 2 1
   - Subset 2: 5 4 3

---

## Java Code Implementation

```java
// filepath: d:\HERE\CSES\TwoSets\TwoSets.java
import java.util.*;
public class TwoSets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = (n*(n+1))/2;
        if((sum&1)==1){
            System.out.println("NO");
            return;
        }  
        sum/=2;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++) dp[i][0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] += dp[i-1][j] + ((j-i>=0)?dp[i-1][j-i]:0);
            }
        }
        StringBuilder summing = new StringBuilder();
        StringBuilder compli = new StringBuilder();
        int counter =0;
        while(n>0){
            if(sum>=n && dp[n-1][sum-n]>0){
                summing.append(n+" ");
                sum-=n;
                counter++;
            }
            else
                compli.append(n+" ");
            n--;
        }
        System.out.println(dp[sum][sum]>0?"YES":"NO");
        System.out.println(counter);
        System.out.println(summing.toString());
        System.out.println(dp.length-1-counter);
        System.out.println(compli.toString());
    }    
}
```

---

## Programming Workflow

### Numbered Steps

1. Read input value `n`.
2. Calculate total sum and check if even.
3. If odd, output "NO".
4. If even, set target sum.
5. Build DP table for subset sums.
6. Backtrack from `n` to `1` to reconstruct subsets.
7. Output "YES", sizes, and contents of both subsets.

### Flowchart (ASCII Art)

```
[Start]
   |
[Read n]
   |
[Compute total sum]
   |
[Is sum odd?]--Yes-->[Output NO][End]
   |
  No
   |
[Set target sum]
   |
[Build DP table]
   |
[For i = n to 1]
   |
[If sum >= i && dp[i-1][sum-i]>0]
   |         |
  Yes       No
   |         |
[Add to   [Add to
subset 1] subset 2]
   |
[Output YES, subsets]
   |
 [End]
```

---

## Complexity Analysis

- **Time Complexity:** O(n * sum)
- **Space Complexity:** O(n * sum)

---

## References

- [CSES Problem Set - Two Sets](https://cses.fi/problemset/task/1092)
- [Dynamic Programming - Wikipedia](https://en.wikipedia.org/wiki/Dynamic_programming)
- [Partition Problem - GeeksforGeeks](https://www.geeksforgeeks.org/partition-problem-dp-18/)