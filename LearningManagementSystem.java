
package learning.management.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LearningManagementSystem {

    public static void main(String[] args) throws IOException {
        new logInAs_screen().setVisible(true);
        
        /*File myObj = new File("Users/lecturers.txt");
        myObj.deleteOnExit();
        */
  
        try (BufferedReader br = new BufferedReader(new FileReader("Files/q.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String []receivedData = line.split(",");
                System.out.println(receivedData[0]+"|"+receivedData[1]+"|"+receivedData[2]);
                if("2".equals(receivedData[0]) && "ryghd".equals(receivedData[1]) && "grd".equals(receivedData[2])){
                    System.out.println("done");
                    break;
                }
                else{
                    System.out.println("bl7");
                }
            }
        }
    }
    
}
