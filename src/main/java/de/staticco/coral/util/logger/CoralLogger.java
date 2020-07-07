package de.staticco.coral.util.logger;

import de.staticco.coral.Coral;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CoralLogger implements Logger, LogFileManager{

    File latestLog;
    PrintStream fileWriter;

    public CoralLogger(File location) {
        latestLog = new File(location.getAbsolutePath() + "/logs", "latest.log");
        createNewLogFile();
    }

    public boolean createNewLogFile() {
        if(!latestLog.exists()) {
            latestLog.getParentFile().mkdirs();
            try {
                latestLog.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }else{
            try {
                Files.move(latestLog.toPath(), latestLog.toPath().resolveSibling("[" + Coral.getInstance().getSavingTimeFormat().format(new Date(Coral.getInstance().getProgramStartMillis())) + "].log"));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            createNewLogFile();
            return true;
        }

        try {
            OutputStream out = new FileOutputStream(latestLog);
            fileWriter = new PrintStream(out,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public File getLatestFile() {
        return latestLog;
    }

    public List<File> getAllFiles() {
        File logFolder = latestLog.getAbsoluteFile();
        return new ArrayList<File>(Arrays.asList(logFolder.listFiles()));
    }



    public void shutDownLatestLogFile() {
        fileWriter.close();
    }

    public void logMessage(Object... object) {
        for(Object obj : object) {
            logMessage(obj.toString());
        }
    }

    public PrintStream getFileWriter() {
        return fileWriter;
    }

    public String logMessage(String string) {
        String time = Coral.getInstance().getTimeFormat().format(System.currentTimeMillis());
        System.setOut(getFileWriter());
        System.setErr(getFileWriter());
        System.out.println("[" + time + "] [Coral] " + string);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("[" + time + "] [Coral] " + string);
        return "[" + time + "] [Coral] " + string;
    }
}
