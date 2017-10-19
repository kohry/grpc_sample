package aa.bb;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class BlockchainClient {
	
	  private final ManagedChannel channel;
	  private final BlockChainGrpc.BlockChainBlockingStub blockingStub;

	  /** Construct client connecting to HelloWorld server at {@code host:port}. */
	  public BlockchainClient(String host, int port) {
	    this(ManagedChannelBuilder.forAddress(host, port)
	        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
	        // needing certificates.
	        .usePlaintext(true)
	        .build());
	  }

//	  /** Construct client for accessing RouteGuide server using the existing channel. */
	  BlockchainClient(ManagedChannel channel) {
	    this.channel = channel;
	    blockingStub = BlockChainGrpc.newBlockingStub(channel);
	  }
//
	  public void shutdown() throws InterruptedException {
	    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	  }

	  /** Say hello to server. */
	  public void greet(String name) {
	    
//	    ProcessRequest request = ProcessRequest.newBuilder().setArgs(name).build();
	    ProcessRequest request2 = ProcessRequest.newBuilder()
	    		.setRequestType(0)
	    		.setArgs("admin")
	    		.build();
	    ProcessResponse response;
	    try {
	      response = blockingStub.processCOMM(request2);
	    } catch (StatusRuntimeException e) {
	      return;
	    }
	    System.out.println("hi");
	  }
	  
	 
	  
}
