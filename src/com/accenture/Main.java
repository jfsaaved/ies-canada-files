package com.accenture;

import com.accenture.filereader.FileReaderExercise;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Main {

    /* When handling files, Java requires you to handle IO exceptions, for this exercise we will use 'throws'
    You use try/catch if you want the program to do some actions when it catches the error.
    eg. If the file doesn't exist, we can do try/catch, and on the catch we will create a new file */
    public static void main(String[] args) throws IOException {

        String fileName = "testing.txt";
        FileReaderExercise fre = new FileReaderExercise(fileName);

        System.out.println("Working with file for reading: " + fileName);
        System.out.println("--------------------------------------------");
        System.out.println("Checking if file exists: " + fre.checkIfFileExists());
        System.out.println("--------------------------------------------");
        System.out.println("Printing contents of the file: " + fre.readContentsOfFile());
        System.out.println("--------------------------------------------");
        System.out.println("Printing first line of the file: " + fre.readContentsOfFileLineByLine().get(0));
        System.out.println("--------------------------------------------");
        System.out.println("Printing first line, using BufferedReader: " + fre.readContentOfFileThroughBufferedReader());
        System.out.println("--------------------------------------------");
        fre.writeToFileThroughBufferedWriter("A random number : " + new Random().nextInt());
        System.out.println("Write and show contents of file using BufferedWrited: " + fre.readContentsOfFile());

    }

}
