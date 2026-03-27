package com.digitaltherapyassistant.cli.commands.auth;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.digitaltherapyassistant.cli.Command;
import com.digitaltherapyassistant.controller.AuthController;
import com.digitaltherapyassistant.dto.response.AuthResponse;

@Component
public class LogoutCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LogoutCommand.class);
    private final AuthController authController;

    public LogoutCommand(AuthController authController) {
        this.authController = authController;
    }

    public String getName() { return "c"; }
    public String getMenuLabel() { return "Logout"; }
    
    public boolean execute(Scanner in) { 
        System.out.print("Enter your access token: ");
        String accesToken = in.nextLine().trim();

        authController.logout(accesToken);

        System.out.println("Logged Out");
        return true;
    }
}
