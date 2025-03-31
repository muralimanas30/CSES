import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long sumAllNat = n*(n+1)/2;
        long currSum = 0;
        for (int i = 0; i < n-1; i++) {
            currSum+= scan.nextLong();
        }
        System.out.println(sumAllNat-currSum);
    }
}