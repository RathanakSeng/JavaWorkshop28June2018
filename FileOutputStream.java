package fileoutputstreamdemo;
import java.io.*;
import java.util.*;
/**
 * @author Rathanak
 */
public class FileOutputStreamDemo
{
    private static final String end = "-1";//Condition to stop execute the program

    private static final byte[] newLine = System.getProperty("line.separator").getBytes();//new_line

    private static final Scanner input = new Scanner(System.in);//Input method

    private static String codeLine = null;//Var contain the input from user

    private static OutputStream file = null;

    public static void main(String[] args)
    {
        System.out.println("\"<<<Write a File>>> \"");
        System.out.println("************************");

        //Access the file
        try
        {
            file = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\HelloWorld.py",true);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFound...");
        }

        //Input to the file
        System.out.println("Enter your code and -1 to finish : ");
        try
        {
            while(true)
            {
                codeLine = input.nextLine();
                if(codeLine.equalsIgnoreCase(end))
                {
                    break;
                }
                file.write(codeLine.getBytes());
                file.write(newLine);
                file.flush();
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException...");
        }
        finally
        {
            try
            {
                file.close();
            }
            catch (IOException ex)
            {
                System.out.println("Cannot close file...");
            }
        }
        System.out.println("Program End...");
        System.out.println("**************");
    }
}
