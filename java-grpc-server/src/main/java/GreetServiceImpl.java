import generated.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void hello(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String reply = request.getMsg() + " > Hi, " + request.getName();
        System.out.println(reply);
        GreetResponse response = GreetResponse.newBuilder().setReply(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void bye(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String reply = request.getMsg() + " > Bye, " + request.getName();
        System.out.println(reply);
        GreetResponse response = GreetResponse.newBuilder().setReply(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}