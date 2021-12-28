/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.management.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class User {
    private int ID = 0;
    private String name = "";
    private String password = "";
    private int userType = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    
    
    int logIn(int userType, int ID, String name, String password) throws FileNotFoundException, IOException{
        
        int existedUser = 0;
        
        if(userType == 1){
            
            try (BufferedReader br = new BufferedReader(new FileReader("Users/admins.txt"))) {
            String line;
            
            while ((line= br.readLine() ) != null) {
                
                    String []receivedData = line.split(",");
                    
                    if(String.valueOf(ID).equals(receivedData[0]) && name.equals(receivedData[1]) && password.equals(receivedData[2])){
                        existedUser = 1;
                        break;
                    }

                }
            }
        }
        
        if(userType == 2){
            try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
            String line;
            
            while ((line= br.readLine() ) != null) {
                
                    String []receivedData = line.split(",");
                    
                    if(String.valueOf(ID).equals(receivedData[0]) && name.equals(receivedData[1]) && password.equals(receivedData[2])){
                        existedUser = 1;
                        break;
                    }

                }
            }
        }
        if(userType == 3){
            try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
            String line;
            
            while ((line= br.readLine() ) != null) {
                
                    String []receivedData = line.split(",");
                    
                    if(String.valueOf(ID).equals(receivedData[0]) && name.equals(receivedData[1]) && password.equals(receivedData[2])){
                        existedUser = 1;
                        break;
                    }

                }
            }
        }
        
        return existedUser;
    }
    
    public void logOut(){
        logInAs_screen.u.setUserType(0);
        logIn_screen.a.setName("");
        logIn_screen.a.setPassword("");
        logIn_screen.a.setID(0);
        logIn_screen.l.setName("");
        logIn_screen.l.setPassword("");
        logIn_screen.l.setID(0);
        logIn_screen.s.setName("");
        logIn_screen.s.setPassword("");
        logIn_screen.s.setID(0);
        
        new logInAs_screen().setVisible(true);
        
        
    }
    
    
    
}
