//Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
//Требуется перехватить все возможные ошибки и вывести их в логгер.
//
//После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате

package Homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;
import java.util.Scanner;

public class task1 {

    public static void send_log(String text) throws IOException{

        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("log_homework_task1.txt", true);
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        logger.log(Level.INFO, text);
        fh.close();

    }


    public static void main(String[] args) throws IOException{
        
        try {

        System.out.println("Введите число: ");
        Scanner scn = new Scanner(System.in);
        Byte number = scn.nextByte();
        scn.close(); 
        String number_str = Byte.toString(number); 

            try (FileWriter writer = new FileWriter("result.txt", false)){

                writer.write(number_str);
                writer.flush();
                writer.close();
            }
            catch(IOException e) {
                System.out.println(e.getMessage());
            }

        }
        catch (Exception e) {
            send_log(e.toString());
        }
    }
}
