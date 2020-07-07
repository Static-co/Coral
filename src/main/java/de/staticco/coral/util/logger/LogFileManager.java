package de.staticco.coral.util.logger;

import java.io.File;
import java.io.PrintStream;
import java.util.List;

public interface LogFileManager {

    //this will return the latest log file
    public File getLatestFile();
    //this will return all log files
    public List<File> getAllFiles();
    //this method will save the last log file, and create a new logging file
    public boolean createNewLogFile();
    //shutdown method
    public void shutDownLatestLogFile();
    //used to write the log to the file
    //fileprinter
    public PrintStream getFileWriter();
}
