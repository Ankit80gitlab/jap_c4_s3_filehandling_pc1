package com.jap.filedemo;

import java.io.*;
import java.util.Spliterator;

public class ReadWriteFile {

    public static void main(String[] args)
    {
        ReadWriteFile readWriteFile = new ReadWriteFile();

        try
        {
            readWriteFile.readDataFromFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //create object of Readers and writers
    public void readDataFromFile() throws IOException
    {
        File file=new File("input.txt");
        FileReader object=new FileReader(file);
        BufferedReader buffer=new BufferedReader(object);
        String str;
        String str1="";

        //reading value from the file
        while((str=buffer.readLine())!=null) {
            str1 = str1+str;
        }

        //splitting with the help of separator
        String [] array1=str1.split(",");

        //assigning variable and creating array
        int n= array1.length;
        String [] array2 = new String[n];
        String [] array3 = new String[n];

        //converting into lowercase and putting in array
        for (int i=0; i<n; i++)
        {
            array2[i] = array1[i].toLowerCase();
        }

        for (int i=0; i<n; i++)
        {
            array3[i] = String.valueOf(array2[i].charAt(0)).toUpperCase()+array2[i].substring(1);
        }

        //converting array to string
        String result="";

        for(int k=0; k<n; k++)
        {
            if(k==array3.length-1)
            {
                result+=array3[k];
            }
            else
            {
                result+=array3[k]+",";
            }
        }
        System.out.println(result);
 

        //writing data
        File file1 = new File("output.txt");
        FileWriter filewriter=new FileWriter(file1);
        String result2=result;
        filewriter.write(result);
        filewriter.close();
    }
}
