package com.accenture.filereader;

import com.accenture.Main;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReaderExercise {

    /* Files class documentation: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html */

    private File file;

    /* We can find items in the same directory as the running class, in this case: Main.class.
    On an actual application, we would have files on a separate folder: "assets", "resources", or a database */
    public FileReaderExercise(String fileName) {
        file = new File(Main.class.getResource(fileName).getFile());
    }

    /* We use the Files exists() method to check if the item exist */
    public boolean checkIfFileExists() {
        return Files.exists(file.toPath());
    }

    /* When handling files, Java requires you to handle IO exceptions, for this exercise we will use 'throws'
    You use try/catch if you want the program to do some actions when it catches the error.

    For example, a file specified by user is not readable, or no network connection available, etc.
    In all these cases, our program doesn't need to exit, instead it can take actions like alerting the user
    or go into a fallback mechanism(like offline working when network not available), etc.

    We use the Files readString() method to get contents of the file*/
    public String readContentsOfFile() throws IOException{
        return Files.readString(file.toPath());
    }

    /*We use the Files readAllLines() method to get contents of the file, line by line, and store them in a List<String>*/
    public List<String> readContentsOfFileLineByLine() throws IOException {
        return Files.readAllLines(file.toPath());
    }

    /* Resource reading BufferedReader and BufferedWriter: https://medium.com/@isaacjumba/why-use-bufferedreader-and-bufferedwriter-classses-in-java-39074ee1a966
    BufferedReader allows you to open the file for reading.
    Instantiating the object automatically opens the file. You need to call close(), which will also flush, to close the file again on runtime.*/
    public String readContentOfFileThroughBufferedReader() throws IOException {
        BufferedReader br = Files.newBufferedReader(file.toPath());
        String content = br.readLine();
        br.close();
        return content;
    }

    /* Resource: https://www.baeldung.com/java-write-to-file */
    public void writeToFileThroughBufferedWriter(String toWrite) throws IOException {
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.append(toWrite);
        bw.close();
    }

    public ArrayList<String> getAllFileNamesInDirectory() {
        File[] listOfFiles = new File (Main.class.getResource("").getPath()).listFiles();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0 ; i < listOfFiles.length; i ++){
            result.add(listOfFiles[i].getName());
        }
        return result;
    }

    public String getFileDirectory() {
        String fileDirectory = new File(Main.class.getResource("").getPath()).getPath();
        return fileDirectory;
    }

}
