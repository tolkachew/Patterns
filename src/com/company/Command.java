package com.company;

import java.util.ArrayList;
import java.util.List;

public class Command {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Fan fan = new Fan();

        Remote remote = new Remote();
        remote.addCommand(new CommandLampOn(lamp));
        remote.addCommand(new CommandFanOn(fan));

        remote.runCommand(0);
        remote.runCommand(1);
    }
}

class Lamp{
    public void turnOn(){
        System.out.println("lamp turn on");
    }
    public void turnOff(){
        System.out.println("lamp turn off");
    }
    public void turnDim(){
        System.out.println("lamp turn dim");
    }
}

class Fan {
    public void turnOn() {
        System.out.println("fan turn on");
    }

    public void turnOff() {
        System.out.println("fan turn off");
    }
}

interface ICommand{
    void run();
}

class Remote{
    List<ICommand> commands = new ArrayList<>();

    public void addCommand(ICommand command){
        commands.add(command);
    }

    public void runCommand(int i){
        commands.get(i).run();
    }
}

class CommandLampOn implements ICommand{
    private Lamp lamp;

    public CommandLampOn(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void run() {
        lamp.turnOn();
    }
}

class CommandFanOn implements ICommand{
    private Fan fan;

    public CommandFanOn(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void run() {
        fan.turnOn();
    }
}


