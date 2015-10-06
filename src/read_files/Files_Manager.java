/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package read_files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import javax.swing.JEditorPane;

/**
 *
 * @author desarrollador
 */
public class Files_Manager extends File{
    String file_route;
    File file;
    FileInputStream read_file;
    FileReader fr;
    FileWriter fw;
    
    public Files_Manager(String File_Route){
        // llamo el constructor padre
        super(File_Route);
        
        this.file = new File(File_Route);
        this.file_route = File_Route;
    }

    public void read(JEditorPane editor) {
        boolean next = false;
        
        try {
            this.read_file = new FileInputStream(this.file_route);
            
            this.read_file = new FileInputStream(this.file);
            
            System.out.println("Total file size to read (in bytes) : "
                           + this.read_file.available() + "\n");
            
            char[] letters = new char[500];
            String row = "";
            
            int count = 0;
            int count_row = 1;
            int content;
            
            while ((content = this.read_file.read()) != -1) {
                // convert to char and display it
                //System.out.println(content);
                if(content == 10 || content == 0){
                    //System.out.print(count);
                    
                    for(int i = 0; i < count; i++){
                       row += letters[i];
                    }
                    
                    next = true;
                    System.out.println(count);
                    editor.setText(row +"\n");
                    count = 0;
                }else if(next){
                    System.out.print(count_row+". ");
                    //row += count_row+". "; 
                    count_row++;
                    next = false;
                    editor.setText(row +"\n");
                    //System.out.println(count);
                }
                letters[count] = (char) content;
                System.out.print((char) content);
                count++;
                
            }
            //editor.setText();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());          
        } catch(IOException exc){
             System.out.println(exc.getMessage()); 
        }
    }
    
    public void read_(JEditorPane edit){
        File f = new File(this.file_route);
        Scanner s;
        try {
            s = new Scanner(f);
            //
            // Aquí la lectura del fichero
            //
           
            String row = "";
           
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                // 
                // Aquí el tratamiento de la línea
                //

               System.out.println(linea);
               row += linea + "\n";
            }
            edit.setText(row);
            s.close();
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }
    
    public void write(String Text){
        try{

            this.fw = new FileWriter(this.file);
            BufferedWriter bw = new BufferedWriter(this.fw);
            PrintWriter wr = new PrintWriter(bw);  
            wr.write("");
            wr.write(Text); //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();
            bw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
