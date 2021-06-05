import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetServerMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Java Grpc Server");

        Server server = ServerBuilder.forPort(9091)
                .addService(new GreetServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
        }));

        server.awaitTermination();
    }
}
