import java.util.*;

public class SubArraySums1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long target = scan.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }

        long currSum = 0;
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > target && left <= right) {
                currSum -= arr[left++];
            }

            if (currSum == target) {
                count++;
            }
        }

        System.out.println(count);
    }
}
