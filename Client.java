import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Lookup the remote object
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);

            // Input numbers
            System.out.print("Enter First Number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter Second Number: ");
            double num2 = sc.nextDouble();

            // Send numbers to server
            System.out.println("\nFirst Number Is: " + num1);
            System.out.println("Second Number Is: " + num2);
            serverIntf.sendNumber(num1, num2);

            // Perform operations
            System.out.println("\n--------------- Results ---------------");
            System.out.println("Addition: " + serverIntf.Addition(num1, num2));
            System.out.println("Subtraction: " + serverIntf.Subtraction(num1, num2));
            System.out.println("Multiplication: " + serverIntf.Multiplication(num1, num2));
            System.out.println("Division: " + serverIntf.Division(num1, num2));

        } catch (Exception e) {
            System.out.println("Exception Occurred At Client: " + e.getMessage());
        }

        sc.close();
    }
}
