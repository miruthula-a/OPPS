import java.io.*; 

import java.util.*; 

public class FileCopy { 

    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in); 

        try { 

            System.out.print("Source File Path: "); 

            String source = sc.nextLine(); 

            System.out.print("Destination File Path: "); 

            String destination = sc.nextLine(); 

           FileReader fr = new FileReader(source); 

            FileWriter fw = new FileWriter(destination); 

            int ch; 

            while ((ch = fr.read()) != -1) { 

                fw.write(ch); 

            } 

            fr.close(); 

            fw.close(); 

            System.out.println("File copied successfully."); 

            System.out.println("Destination File Created: " + destination); 

         } catch (IOException e) { 

            System.out.println("Error: " + e.getMessage()); 

        } 

         sc.close(); 

    } 

} 

 

