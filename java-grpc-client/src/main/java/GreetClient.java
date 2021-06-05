import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import generated.*;

public class GreetClient {
    public static void main(String[] args) {
        System.out.println("Java Grpc Client");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9091)
                .usePlaintext()
                .build();

        GreetServiceGrpc.GreetServiceBlockingStub stub = GreetServiceGrpc.newBlockingStub(channel);

        GreetResponse helloResponse = stub.hello(GreetRequest.newBuilder().setName("Java").setMsg("hello gRPC").build());
        System.out.println(helloResponse.getReply());

        GreetResponse byeResponse = stub.bye(GreetRequest.newBuilder().setName("Java").setMsg("Bye gRPC").build());
        System.out.println(byeResponse.getReply());

        channel.shutdown();
    }
}