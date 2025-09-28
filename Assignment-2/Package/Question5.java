import mypackage.Odd;
import java.util.*;

public class Question5 {
    public static void main(String args[]) {
        Odd even = new Odd();
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int a = sobj.nextInt();
        even.checkOdd(a);
    }
}