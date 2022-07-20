package com.jap.filedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadWriteFileTests {

    ReadWriteFile readWriteFile;
    @BeforeEach
    public void setUp() {
        readWriteFile = new ReadWriteFile();
    }

    @AfterEach
    public void tearDown() {
        readWriteFile = null;
    }

    @Test
    public void givenInputFileThenCheckForCorrectResult() throws IOException {

        String string = "Jenny,Jonathan,Harry,Jonny,Samatha,Michael,Robert,David,Smith,Garcia,William,Thomas,Daniel,Matthew,Anthony";
        String string1 = "";
        readWriteFile.readDataFromFile();
        FileInputStream fis = new FileInputStream("output.txt");
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
           string1= string1.concat(scanner.nextLine());
        }

       assertEquals(string,string1);


    }

}
