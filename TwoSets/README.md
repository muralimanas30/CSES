# Two Sets Problem Solution

## Problem Statement

Given a positive integer `n`, divide the set of integers `{1, 2, ..., n}` into two subsets with equal sums. If possible, output "YES" and the two subsets; otherwise, output "NO".

For more details, see the [CSES Problem Page](https://cses.fi/problemset/task/1092).

---

## Example Inputs and Outputs

### Case 1: Partition Possible

#### Input
```
7
```
#### Output
```
YES
4
1 2 4 7
3
3 5 6
```

#### Input
```
8
```
#### Output
```
YES
4
1 3 6 8
4
2 4 5 7
```

### Case 2: Partition Impossible

#### Input
```
1
```
#### Output
```
NO
```

#### Input
```
5
```
#### Output
```
NO
```

---

## Algorithm Overview

The solution uses a greedy approach based on the parity of the total sum. If the sum of numbers from 1 to n is even, we can partition the set; otherwise, it's impossible. The algorithm iteratively selects the largest available number to add to one subset until the target sum is reached.

This approach is chosen for its simplicity and efficiency, avoiding unnecessary dynamic programming for this specific problem.

---

## Variables and Data Structures

| Variable      | Type           | Description                                                         |
|---------------|----------------|---------------------------------------------------------------------|
| `n`           | int            | The input number, size of the set                                   |
| `input`       | long           | The total sum of the first `n` integers                             |
| `sum`         | int            | Target sum for each subset (half of total sum)                      |
| `summing`     | StringBuilder  | Stores elements of the first subset                                 |
| `compli`      | StringBuilder  | Stores elements of the second subset                                |
| `counter`     | int            | Number of elements in the first subset                              |

---

## Step-by-Step Breakdown

1. Read integer `n`.
2. Compute the total sum of numbers from 1 to n.
3. If the sum is odd, print "NO" and exit.
4. Set target sum as half of total sum.
5. Starting from `n`, greedily add numbers to the first subset if it doesn't exceed the target sum.
6. Remaining numbers go to the second subset.
7. Output the result.

---

## Visual Diagram

```
Set: {1, 2, 3, 4, 5, 6, 7}
Total sum = 28 (even)
Target sum for each subset = 14

Greedy selection:
- Take 7 (sum=7), take 6 (sum=13), take 1 (sum=14) → Subset 1: {1, 6, 7}
- Remaining: {2, 3, 4, 5} → Subset 2: {2, 3, 4, 5}
(Actual output may differ based on implementation order)
```

---

## Step-by-Step Walkthrough (n = 7)

1. Total sum = 28 (even), target = 14.
2. Start from 7:
   - 7 fits in subset 1 (sum=7)
   - 6 fits in subset 1 (sum=13)
   - 5 doesn't fit (would exceed 14), goes to subset 2
   - 4 fits in subset 1 (sum=13+4=17, exceeds 14), so goes to subset 2
   - 3 fits in subset 1 (sum=13+3=16, exceeds 14), so goes to subset 2
   - 2 fits in subset 1 (sum=13+2=15, exceeds 14), so goes to subset 2
   - 1 fits in subset 1 (sum=13+1=14), subset 1 complete

   Final subsets (one possible partition):
   - Subset 1: 1 2 4 7
   - Subset 2: 3 5 6

---

## Java Code Implementation

```java
// filepath: d:\HERE\CSES\TwoSets\TwoSets.java
package TwoSets;
n = 7
```

---

## Programming Workflow

### Numbered Steps

1. Read input value `n`.
2. Calculate total sum and check if even.
3. If odd, output "NO".
4. If even, set target sum.
5. Iterate from `n` down to 1:
    - If current number fits in target sum, add to subset 1.
    - Else, add to subset 2.
6. Output "YES", sizes, and contents of both subsets.

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
[For i = n to 1]
   |
[If i <= target sum]
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

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

---

## References

- [CSES Problem Set - Two Sets](https://cses.fi/problemset/task/1092)
- [Greedy Algorithms - Wikipedia](https://en.wikipedia.org/wiki/Greedy_algorithm)
- [Partition Problem - GeeksforGeeks](https://www.geeksforgeeks.org/partition-problem-dp-18/)
