package com.digitaltherapyassistant.cli.commands.crisis;

import java.util.List;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

import org.springframework.stereotype.Component;

import com.digitaltherapyassistant.cli.Command;
import com.digitaltherapyassistant.cli.CommandLineException;
import com.digitaltherapyassistant.cli.MenuHandler;
import com.digitaltherapyassistant.cli.commands.BackCommand;
import com.digitaltherapyassistant.cli.commands.ExitCommand;

@Component
public class CrisisSupportMenuCommand implements Command {
    private MenuHandler crisisMenuHandler;

    public CrisisSupportMenuCommand(
        CopingStrategiesCommand copingStrategiesCommand,
        EmergencyResourcesCommand emergencyResourcesCommand,
        SafetyPlanCommand safetyPlanCommand,
        BackCommand backCommand
    ){
       crisisMenuHandler = new MenuHandler(
                List.of(copingStrategiesCommand, emergencyResourcesCommand,
                safetyPlanCommand, backCommand));
    }

    public String getName() { return "5"; }
    public String getMenuLabel() { return "Crisis Support"; }
    
    public boolean execute(Scanner in) {
        crisisMenuHandler.runMenu("Crisis Menu", in);
        return true;
    }
}
