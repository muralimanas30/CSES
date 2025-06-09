# Two Sets Problem Solution

## Problem Statement
The Two Sets problem is a classic problem in combinatorial optimization. Given a positive integer `n`, the task is to divide the set of integers from `1` to `n` into two subsets such that the sum of the elements in both subsets is equal. If such a division is possible, the program should output "YES" and the two subsets; otherwise, it should output "NO".

For more details, visit the [CSES Problem Page](https://cses.fi/problemset/task/1092).

## Example Inputs and Outputs
### Input
```
n = 7
```
### Output
```
YES
4 3
1 2 5 6 7
```

### Input
```
n = 1
```
### Output
```
NO
```

## Algorithm Overview
The solution uses dynamic programming to determine if it is possible to partition the set into two subsets with equal sums. The approach is chosen because it efficiently computes the possible sums that can be formed with the given numbers.

## Variables and Data Structures
| Variable | Type          | Description |
|----------|---------------|-------------|
| `n`      | int           | The input number representing the largest integer in the set. |
| `input`  | long          | The total sum of the first `n` integers. |
| `sum`    | int           | Half of the total sum, which is the target sum for each subset. |
| `dp`     | int[][]       | A 2D array used for dynamic programming to track the number of ways to achieve each sum with the first `i` numbers. |
| `summing`| StringBuilder  | A string builder to construct the first subset. |
| `compli` | StringBuilder  | A string builder to construct the second subset. |
| `counter`| int           | A counter to track the number of elements in the first subset. |

## Step-by-Step Breakdown of the Algorithm
1. Read the integer `n` from input.
2. Calculate the total sum of the first `n` integers.
3. Check if the total sum is odd. If it is, print "NO" and exit.
4. Initialize a dynamic programming table `dp` where `dp[i][j]` represents the number of ways to achieve the sum `j` using the first `i` integers.
5. Fill the `dp` table based on the inclusion-exclusion principle.
6. Construct the two subsets by backtracking through the `dp` table.
7. Print the results.

## Visual Diagrams
```
Dynamic Programming Table (dp):
    0  1  2  3  4  5  6  7
0 [1, 0, 0, 0, 0, 0, 0, 0]
1 [1, 1, 1, 1, 1, 1, 1, 1]
2 [1, 1, 1, 2, 2, 2, 2, 2]
3 [1, 1, 1, 2, 3, 3, 4, 4]
...
```

## Step-by-Step Walkthrough
For `n = 7`:
1. Total sum = 28 (even).
2. Target sum for each subset = 14.
3. Fill the `dp` table.
4. Backtrack to find subsets: {4, 3} and {1, 2, 5, 6, 7}.

## Java Code Implementation
```java
// filepath: d:\HERE\CSES\TwoSets\TwoSets.java
import java.util.*;
public class TwoSets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long input = (n*(n+1l))/2l;
        if((input&1)==1){
            System.out.println("NO");
            return;
        }  
        int sum = (int)input/2;

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

## Programming Workflow
1. Read input value `n`.
2. Calculate total sum and check for evenness.
3. Initialize and fill the `dp` table.
4. Construct subsets based on the `dp` table.
5. Output results.

```
Flowchart:
[Start] --> [Read n] --> [Calculate sum] --> [Check if sum is odd] --> [Initialize dp] --> [Fill dp] --> [Construct subsets] --> [Output results] --> [End]
```

## Complexity Analysis
- Time Complexity: O(n * sum), where `n` is the input number and `sum` is half of the total sum.
- Space Complexity: O(n * sum) for the dynamic programming table.

## References
- Dynamic Programming techniques.
- Combinatorial optimization problems.