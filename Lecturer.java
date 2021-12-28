/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.management.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Abbas
 */
public class Lecturer extends User{
    public int enterCourse(int userId, String courseName){
        int returnValue = 0;
        try {
                File myObj = new File("Courses/"+userId+"/courses.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    
                    if (data.equals(courseName)) {
                        returnValue = 1;
                        break;
                    }

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    return returnValue;    
    }
    
}
