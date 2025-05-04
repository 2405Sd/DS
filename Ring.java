import java.util.*;

public class Ring {
    int totalProcesses;
    int coordinator;
    boolean[] isAlive;
    Scanner scanner = new Scanner(System.in);

    public Ring(int n) {
        totalProcesses = n;
        isAlive = new boolean[n];
        for (int i = 0; i < n; i++) {
            isAlive[i] = true;
            System.out.println("Process P" + (i + 1) + " is created and alive.");
        }
        coordinator = n;
        System.out.println("P" + coordinator + " is initially the coordinator.");
    }

    void displayProcesses() {
        for (int i = 0; i < totalProcesses; i++) {
            System.out.println("P" + (i + 1) + " is " + (isAlive[i] ? "UP" : "DOWN"));
        }
        System.out.println("Current Coordinator: P" + coordinator);
    }

    void bringUpProcess(int id) {
        if (isAlive[id - 1]) {
            System.out.println("P" + id + " is already UP.");
        } else {
            isAlive[id - 1] = true;
            System.out.println("P" + id + " is brought UP.");
        }
    }

    void bringDownProcess(int id) {
        if (!isAlive[id - 1]) {
            System.out.println("P" + id + " is already DOWN.");
        } else {
            isAlive[id - 1] = false;
            System.out.println("P" + id + " is brought DOWN.");
        }
    }

    void startElection(int initiator) {
        if (!isAlive[initiator - 1]) {
            System.out.println("P" + initiator + " is DOWN. Cannot start election.");
            return;
        }

        List<Integer> ring = new ArrayList<>();
        int index = initiator - 1;

        do {
            if (isAlive[index]) {
                ring.add(index + 1);
            }
            index = (index + 1) % totalProcesses;
        } while (index != initiator - 1);

        System.out.println("Election message passed: " + ring);
        coordinator = Collections.max(ring);
        System.out.println("P" + coordinator + " is elected as new coordinator.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Ring ring = null;

        while (true) {
            System.out.println("\n--- Ring Election Algorithm ---");
            System.out.println("1. Create Processes");
            System.out.println("2. Display Process Status");
            System.out.println("3. Bring UP a Process");
            System.out.println("4. Bring DOWN a Process");
            System.out.println("5. Start Election");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = input.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter number of processes: ");
                    int n = input.nextInt();
                    ring = new Ring(n);
                    break;
                case 2:
                    if (ring != null) ring.displayProcesses();
                    else System.out.println("Create processes first.");
                    break;
                case 3:
                    System.out.print("Enter process ID to bring UP: ");
                    int up = input.nextInt();
                    ring.bringUpProcess(up);
                    break;
                case 4:
                    System.out.print("Enter process ID to bring DOWN: ");
                    int down = input.nextInt();
                    ring.bringDownProcess(down);
                    break;
                case 5:
                    System.out.print("Enter initiator process ID: ");
                    int initiator = input.nextInt();
                    ring.startElection(initiator);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
