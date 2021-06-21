package com.mycompany.client;

import com.mycompany.grpc.User;
import com.mycompany.grpc.userServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        // stub from proto file
        userServiceGrpc.userServiceBlockingStub stub = userServiceGrpc.newBlockingStub(channel);

        User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("lad").setPassword("gaurav").build();

        User.APIResponse response = stub.login(request);

        System.out.println(response.getResponseMessage());
    }


}
