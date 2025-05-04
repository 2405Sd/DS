import java.rmi.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the server implementation
            ServerImpl serverImpl = new ServerImpl();

            // Bind the remote object to the RMI registry
            Naming.rebind("Server", serverImpl);

            System.out.println("Server Started....");
        } catch (Exception e) {
            System.out.println("Exception Occurred At Server: " + e.getMessage());
        }
    }
}
