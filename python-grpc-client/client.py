import grpc
import greet_pb2
import greet_pb2_grpc

def run():
    channel = grpc.insecure_channel('localhost:9091')
    stub = greet_pb2_grpc.GreetServiceStub(channel)
    
    response = stub.Hello(greet_pb2.GreetRequest(name="Python", msg="Hello~!"))
    print(str(response.reply))

    response = stub.Bye(greet_pb2.GreetRequest(name="Python", msg="Bye~!"))
    print(str(response.reply))

if __name__ == '__main__':
    run()