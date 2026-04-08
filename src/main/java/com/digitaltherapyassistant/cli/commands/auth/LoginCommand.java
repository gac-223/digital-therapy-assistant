package com.digitaltherapyassistant.cli.commands.auth;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.digitaltherapyassistant.cli.Command;
import com.digitaltherapyassistant.cli.api.auth.AuthAPIClient;
import com.digitaltherapyassistant.dto.request.auth.LoginRequest;

@Slf4j
@Component
public class LoginCommand implements Command {
    private final AuthAPIClient authApiClient;

    public LoginCommand(AuthAPIClient authApiClient) {
        this.authApiClient = authApiClient;
    }

    @Override
    public String getName() { return "b"; }

    @Override
    public String getMenuLabel() { return "Login"; }

    @Override
    public boolean execute(Scanner in) {
        System.out.print("Enter Email: ");
        String email = in.nextLine();
        System.out.print("Enter Password: ");
        String password = in.nextLine();

        LoginRequest request = new LoginRequest();
        request.setEmail(email);
        request.setPassword(password);

        authApiClient.login(request);

        return true;
    }
}
