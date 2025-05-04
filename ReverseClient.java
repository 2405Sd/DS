import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import java.io.*;

public class ReverseClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            Reverse reverseImpl = ReverseHelper.narrow(ncRef.resolve_str("Reverse"));

            System.out.print("Enter String: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            String result = reverseImpl.reverse_string(input);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
