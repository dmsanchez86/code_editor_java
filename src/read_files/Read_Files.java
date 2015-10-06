/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package read_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author desarrollador
 */
public class Read_Files {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("public/robots");
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(file);

            System.out.println("Total file size to read (in bytes) : "
                            + fis.available());
            
            int count = 1;
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                //System.out.println(content);
                if(content == 10){
                    System.out.println("-");
                }
                
                System.out.print((char) content);
                count++;
            }

        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
}
