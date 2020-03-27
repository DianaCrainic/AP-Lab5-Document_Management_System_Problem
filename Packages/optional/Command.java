package com.optional;

import com.compulsory.Catalog;

/**
 * Command class: manages the commands
 */
public abstract class Command {
    private String command;
    private String argument;

    private Command(){

    }

    public Command(String command) {
        this.command = command;
    }

    public Command(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    public String getCommand() {
        return command;
    }

    public String getArgument() {
        return argument;
    }

    public abstract Catalog executeCommand(Catalog catalog, Object...argument);

    @Override
    public String toString() {
        return "Command: " + command + " " + argument;
    }
}
