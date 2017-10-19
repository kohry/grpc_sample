package aa.bb;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BlockchainClient client = new BlockchainClient("13.124.171.28", 50051);
        client.greet("hi");
    }
}
