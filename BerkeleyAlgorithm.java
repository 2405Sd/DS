import java.util.*;

public class BerkeleyAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of slave clocks: ");
        int n = sc.nextInt();

        int[] slaveClocks = new int[n];  // Clocks of slave systems
        int masterClock;

        System.out.print("Enter master clock time (in seconds): ");
        masterClock = sc.nextInt();

        System.out.println("Enter time for each slave clock (in seconds):");
        for (int i = 0; i < n; i++) {
            System.out.print("Slave " + (i + 1) + ": ");
            slaveClocks[i] = sc.nextInt();
        }

        // Simulate request & response delays (round trip)
        int[] delay = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            delay[i] = rand.nextInt(5);  // Simulate 0 to 4 seconds delay
        }

        // Adjust slave clock times for delay
        int sum = 0;
        for (int i = 0; i < n; i++) {
            slaveClocks[i] += delay[i] / 2;  // Assuming symmetric delay
            sum += slaveClocks[i];
        }

        // Calculate average (only slaves)
        int avg = sum / n;

        System.out.println("\n--- Clock Adjustment Summary ---");
        System.out.println("Master clock time: " + masterClock);
        System.out.println("Average of slave clocks (adjusted): " + avg + " seconds\n");

        System.out.println("Adjustments required (in seconds):");
        System.out.println("Master: " + (avg - masterClock));
        for (int i = 0; i < n; i++) {
            System.out.println("Slave " + (i + 1) + ": " + (avg - slaveClocks[i]));
        }

        sc.close();
    }
}
