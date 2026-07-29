import java.util.*;
class Intrest{
   public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);
       double p = sc.nextDouble();
       double r = sc.nextDouble();
       double t = sc.nextDouble();
       double intrest = (p * r * t) / 100;
       System.out.println("Celsius to Fahrenheit Conversion is " + intrest);
   }
}
