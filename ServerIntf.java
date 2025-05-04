import java.rmi.*;

// Remote Interface declaring the methods that can be invoked remotely
public interface ServerIntf extends Remote {
    public void sendNumber(double num1, double num2) throws RemoteException;
    public double Addition(double num1, double num2) throws RemoteException;
    public double Subtraction(double num1, double num2) throws RemoteException;
    public double Multiplication(double num1, double num2) throws RemoteException;
    public double Division(double num1, double num2) throws RemoteException;
}
