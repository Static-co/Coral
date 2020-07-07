package de.staticco.coral;

import de.staticco.coral.task.AsyncConsoleListener;
import de.staticco.coral.util.logger.CoralLogger;
import de.staticco.coral.util.logger.LogFileManager;
import de.staticco.coral.util.logger.Logger;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

public  class Coral {

    private static Coral instance;

    //this is the main logging system of the main plugin, all messages will be logged in a file, called after the date of startup of the bot
    private Logger logger;
    private LogFileManager logFileManager;

    //this is the main time format used in the howl program (DE)
    private SimpleDateFormat timeFormat =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    //this is the time format used for the log files.
    private SimpleDateFormat savingTimeFormat =  new SimpleDateFormat("dd MM yyyy HH-mm-ss");

    public static Coral getInstance() {
        return instance;
    }

    //this is the main startup method
    public static void main(String[] args) {
        new Coral();
    }

    //those are the two timeStamps when the program started running first.
    private long programStartMillis;
    private Date programStartDate;

    //the location where the executed java lays on the system
    private File location;

    //input Scanner
    Scanner scanner;

    //the startup method from the coral project
    //By StaticRed
    public Coral() {
        instance = this;
        programStartMillis = System.currentTimeMillis();
        programStartDate = new Date(programStartMillis);
        scanner = new Scanner(System.in);

        //this will figure out where the .jar file is located
        URL urlLocation = getClass().getProtectionDomain().getCodeSource().getLocation();
        location = new File(urlLocation.getPath()).getParentFile();

        CoralLogger coralLogger;

        //this is the main logging system.
        try {
            coralLogger = new CoralLogger(location);
            logger = coralLogger;
        } catch (Exception e) {
            e.printStackTrace();
            disableProgram();
            return;
        }

        logger.logMessage("Starting Coral at: " + getSavingTimeFormat().format(programStartMillis));
        logger.logMessage("Coral main folder: " + location.getParentFile().getAbsolutePath());
    }

    public void startConsoleListener() {
        Timer timer = new Timer();
        timer.schedule(new AsyncConsoleListener(),0,1);
    }

    public void disableProgram() {

    }

    public Date getProgramStartDate() {
        return programStartDate;
    }

    public long getProgramStartMillis() {
        return programStartMillis;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public File getLocation() {
        return location;
    }

    public SimpleDateFormat getSavingTimeFormat() {
        return savingTimeFormat;
    }

    public SimpleDateFormat getTimeFormat() {
        return timeFormat;
    }

    public Logger logger() {return logger;}


}
