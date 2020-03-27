package com.optional;

import java.util.ArrayList;
import java.util.List;

/**
 * Shell class: gets the commands and arguments
 */
public class Shell {
    private List<Command> commandsList = new ArrayList<>();

    public Command getCommand(String thisCommand){
        for(Command command: commandsList){
            if(command.getCommand().equals(thisCommand)){
                return command;
            }
        }
        return null;
    }

    public void addCommand(Command thisCommand){
        commandsList.add(thisCommand);
    }

    /**
     * building the command
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Command command : commandsList) {
            stringBuilder.append(command.getCommand());
            if (command.getArgument() != null) {
                stringBuilder.append(" ").append(command.getArgument());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
