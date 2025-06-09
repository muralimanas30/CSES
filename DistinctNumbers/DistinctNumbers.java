package DistinctNumbers;
import java.util.*;
public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashSet<Integer> found = new HashSet<>();
        for(int i=0;i<n;i++){
            found.add(scan.nextInt());
        }
        System.out.println(found.size());

        }
}
