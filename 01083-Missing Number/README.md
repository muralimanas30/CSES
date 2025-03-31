## 📝 **CSES Problem**
| 🔢 Problem Number | 📌 Title | 🔗 Link |
|------------------|--------------------------|--------------------------|
| 1083 | Missing Number | [CSES Problem](https://cses.fi/problemset/task/1083/) |

---

## 💡 **Problem Explanation**

You are given an array containing $n-1$ distinct numbers in the range $[1, n]$. Your task is to find the missing number.

**Input:** The first line contains an integer $n$. The next line contains $n-1$ distinct integers $x_1, x_2, \dots, x_{n-1}$.

**Output:** Print the missing number.

**Example:**

Input:
```
5
1 2 4 5
```

Output:
```
3
```

---

## 📊 **Algorithm**

1.  Read the integer $n$ from the input.
2.  Calculate the sum of numbers from 1 to $n$ using the formula: `sum = n * (n + 1) / 2`.
3.  Read the $n-1$ numbers from the input and calculate their sum.
4.  Subtract the sum of the given numbers from the sum of numbers from 1 to $n$. The result is the missing number.
5.  Print the missing number.

## 🔥 **Code Implementation**

```java
import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sumOfN = n * (n + 1) / 2;
        long sumOfGiven = 0;

        for (int i = 0; i < n - 1; i++) {
            sumOfGiven += scanner.nextLong();
        }

        System.out.println(sumOfN - sumOfGiven);
        scanner.close();
    }
}
```

## 🚀 **Time & Space Complexity**

*   **Time Complexity:** The algorithm iterates through the input array of size $n-1$ once, so the time complexity is **O(n)**.
*   **Space Complexity:** The algorithm uses a constant amount of extra space for variables like `n`, `sumOfN`, and `sumOfGiven`. Therefore, the space complexity is **O(1)**.
