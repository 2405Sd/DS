import ReverseModule.ReversePOA;

class ReverseImpl extends ReversePOA {
    public ReverseImpl() {
        super();
        System.out.println("Reverse Object Created");
    }

    public String reverse_string(String name) {
        System.out.println("String Received: " + name);
        StringBuilder str = new StringBuilder(name);
        str.reverse();
        return "Server Send " + str.toString();
    }
}
