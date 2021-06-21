package com.mycompany.service;


import com.mycompany.grpc.User;
import com.mycompany.grpc.userServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userServiceGrpc.userServiceImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        System.out.println("username: "+ username + "\npassword: "+password);
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(password.contains(username)){
            //fail
            response.setResponseCode(400).setResponseMessage("invalid username and password");
        }else{
            //accept
            response.setResponseCode(200).setResponseMessage("success");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
