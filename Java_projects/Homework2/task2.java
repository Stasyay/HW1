// Напишите программу, которая
// 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
// 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
// 3) сохраняет файл локально
// 4) читает сохраненный файл и выводит содержимое в логгер
// 5) удаляет сохраненный файл


package Homework2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.logging.*;


public class task2 {

    public static void download_file (URL url, String file_name) throws IOException{

        InputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream out = new FileOutputStream(file_name);
        System.out.println("Download start!");

        byte data[] = new byte[1024];
        int count = -1;
        while((count = in.read(data)) != -1) { 
            out.write(data, 0, count);
        }
        System.out.println("Download finish!");
        
        in.close();
        out.close();
        return ; 
    }

    public static void change_text_in_file(String file_name) throws IOException{

        try {
            String content = Files.lines(Paths.get(file_name))
                            .collect(Collectors.joining(System.lineSeparator()));

            send_log(content);
            String content_change = String.format(content, "Настя");  
            send_log(content_change);
            
            FileWriter writer = new FileWriter(file_name, false);
                writer.write(content_change);
                writer.flush();
                writer.close();
        }
                       
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        return;
    }
   
    public static void send_log(String text) throws IOException{

        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("log.xml", true);
        logger.addHandler(fh);
        
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);

        logger.log(Level.INFO, text);
        fh.close();
    }

    public static boolean delete_file(String file_name){

        file_name = "/" + file_name;

        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(file_name);
        File file = new File(pathFile);

        return file.delete();
     
    }

    public static void main(String[] args) throws IOException{
        
        String file_name = "example.txt";     
        URL url = new URL("https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt");
        
        download_file(url, file_name);
        change_text_in_file(file_name);
        delete_file(file_name);
    }

}
