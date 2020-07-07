package de.staticco.coral.task;

import de.staticco.coral.Coral;

import java.util.Scanner;
import java.util.TimerTask;

public class AsyncConsoleListener extends TimerTask {

    public AsyncConsoleListener() {
    }

    @Override
    public void run() {
        Scanner scanner = Coral.getInstance().getScanner();
        if(scanner.hasNext()) {
            Coral.getInstance().getCommandInputListener().execute(scanner.nextLine());
        }
    }

}
