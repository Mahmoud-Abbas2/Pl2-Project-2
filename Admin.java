/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.management.system;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Abbas
 */
public class Admin extends User {

    public void addUsers(int userType, String name, String password, int ID, JLabel l) throws IOException {
        if (userType == 2) {
            int userExisted = 0;
            try {
                File myObj = new File("Users/lecturers.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    int id = Integer.valueOf(data.split(",")[0]);
                    if (id == ID) {
                        userExisted = 1;
                        l.setText("ID already exists");
                        l.setForeground(Color.red);
                        break;
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            if (userExisted != 1) {

                FileWriter fw = new FileWriter("Users/lecturers.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                File f = new File("Users/lecturers.txt");
                if (f.length() == 0) {
                    bw.write(ID + "," + name + "," + password);

                } else {
                    bw.write("\n" + ID + "," + name + "," + password);

                }

                //bw.newLine();
                bw.close();
            }
        }
        if (userType == 3) {
            int userExisted = 0;
            try {
                File myObj = new File("Users/students.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    int id = Integer.valueOf(data.split(",")[0]);
                    if (id == ID) {
                        userExisted = 1;
                        l.setText("ID already exists");
                        l.setForeground(Color.red);
                        break;
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            if (userExisted != 1) {
                FileWriter fw = new FileWriter("Users/students.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                File f = new File("Users/students.txt");
                //bw.newLine();
                if (f.length() == 0) {
                    bw.write(ID + "," + name + "," + password);

                } else {
                    bw.write("\n" + ID + "," + name + "," + password);

                }
                bw.close();
            }
        }
    }

    public void viewUsers(int userType, JTextArea t) throws FileNotFoundException, IOException {
        t.setText("");
        if (userType == 2) {
            try {
                File myObj = new File("Users/lecturers.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    t.append(data + "\n");
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
        if (userType == 3) {
            try {
                File myObj = new File("Users/students.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    t.append(data + "\n");
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

    }

    public void deleteUser(int userType, int ID, JLabel l) throws IOException {
        String allData = "";

        if (userType == 2) {
            try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
                int userExists = 0;
                String line;
                int x = 0;
                while ((line = br.readLine()) != null) {
                    String[] receivedData = line.split(",");
                    if (receivedData[0].equals(String.valueOf(ID))) {
                        userExists = 1;
                    } else {
                        if (x == 0) {
                            allData = allData + line;
                            x++;
                        } else {
                            allData = allData + "\n" + line;
                        }
                    }

                }

                if (userExists == 0) {
                    l.setText("User doesn't exist");
                    l.setForeground(Color.red);
                    return;
                }

                FileWriter writer = new FileWriter("Users/lecturers.txt", false);
                writer.write(allData);
                writer.close();

                x = 0;
            }
        }

        if (userType == 3) {
            try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
                String line;
                int x = 0;
                int userExists = 0;
                while ((line = br.readLine()) != null) {
                    String[] receivedData = line.split(",");
                    if (receivedData[0].equals(String.valueOf(ID))) {
                        userExists = 1;
                    } else {
                        if (x == 0) {
                            allData = allData + line;
                            x++;
                        } else {
                            allData = allData + "\n" + line;
                        }
                    }

                }

                if (userExists == 0) {
                    l.setText("User doesn't exist");
                    l.setForeground(Color.red);
                    return;
                }

                FileWriter writer = new FileWriter("Users/students.txt", false);
                writer.write(allData);
                writer.close();

                x = 0;
            }
        }

    }

    public int goToUser(int userType, int ID) {
        int returnValue = 0;
        if (userType == 2) {

            try {
                File myObj = new File("Users/lecturers.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    int id = Integer.valueOf(data.split(",")[0]);
                    if (id == ID) {
                        returnValue = 1;
                        break;
                    }

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

        if (userType == 3) {

            try {
                File myObj = new File("Users/students.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    int id = Integer.valueOf(data.split(",")[0]);
                    if (id == ID) {
                        returnValue = 1;
                        break;
                    }

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

        return returnValue;
    }

    public void changeUserType(int userType, int ID, JLabel l) throws IOException {
        if (userType == 2) {
            int exists = 0;
            try {

                File myObj = new File("Users/students.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (ID == Integer.valueOf(data.split(",")[0])) {
                        l.setText("there is a student with this info");
                        l.setForeground(Color.red);
                        exists = 1;
                    }
                }
                if (exists != 1) {
                    try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
                        int userExists = 0;
                        String line;
                        int x = 0;
                        String allData = "";
                        while ((line = br.readLine()) != null) {
                            String[] receivedData = line.split(",");
                            if (receivedData[0].equals(String.valueOf(ID))) {
                                FileWriter fw = new FileWriter("Users/students.txt", true);
                                BufferedWriter bw = new BufferedWriter(fw);
                                File f = new File("Users/students.txt");
                                //bw.newLine();
                                if (f.length() == 0) {
                                    bw.write(line);

                                } else {
                                    bw.write("\n" + line);

                                }
                                bw.close();

                            } else {
                                if (x == 0) {
                                    allData = allData + line;
                                    x++;
                                } else {
                                    allData = allData + "\n" + line;
                                }
                            }

                        }

                        FileWriter writer = new FileWriter("Users/lecturers.txt", false);
                        writer.write(allData);
                        writer.close();

                        x = 0;
                    }

                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        if (userType == 3) {
            int exists = 0;
            try {

                File myObj = new File("Users/lecturers.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (ID == Integer.valueOf(data.split(",")[0])) {
                        l.setText("there is a lecturer with this info");
                        l.setForeground(Color.red);
                        exists = 1;
                    }
                }
                if (exists != 1) {
                    try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
                        int userExists = 0;
                        String line;
                        int x = 0;
                        String allData = "";
                        while ((line = br.readLine()) != null) {
                            String[] receivedData = line.split(",");
                            if (receivedData[0].equals(String.valueOf(ID))) {
                                FileWriter fw = new FileWriter("Users/lecturers.txt", true);
                                BufferedWriter bw = new BufferedWriter(fw);
                                File f = new File("Users/lecturers.txt");
                                //bw.newLine();
                                if (f.length() == 0) {
                                    bw.write(line);

                                } else {
                                    bw.write("\n" + line);

                                }
                                bw.close();

                            } else {
                                if (x == 0) {
                                    allData = allData + line;
                                    x++;
                                } else {
                                    allData = allData + "\n" + line;
                                }
                            }

                        }

                        FileWriter writer = new FileWriter("Users/students.txt", false);
                        writer.write(allData);
                        writer.close();

                        x = 0;
                    }

                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public void updateUserInfo(int userType, int ID, String newName, String newPassword) throws FileNotFoundException, IOException {
        if (userType == 2) {
            try (BufferedReader br = new BufferedReader(new FileReader("Users/lecturers.txt"))) {
                String allData = "";
                int userExists = 0;
                String line;
                int x = 0;
                while ((line = br.readLine()) != null) {
                    String[] receivedData = line.split(",");
                    if (receivedData[0].equals(String.valueOf(ID))) {
                        line = receivedData[0] + "," + newName + "," + newPassword;
                    }
                    if (x == 0) {
                        allData = allData + line;
                        x++;
                    } else {
                        allData = allData + "\n" + line;
                    }

                }

                FileWriter writer = new FileWriter("Users/lecturers.txt", false);
                writer.write(allData);
                writer.close();

            }
        }
        if (userType == 3) {
            try (BufferedReader br = new BufferedReader(new FileReader("Users/students.txt"))) {
                String allData = "";
                int userExists = 0;
                String line;
                int x = 0;
                while ((line = br.readLine()) != null) {
                    String[] receivedData = line.split(",");
                    if (receivedData[0].equals(String.valueOf(ID))) {
                        line = receivedData[0] + "," + newName + "," + newPassword;
                    }
                    if (x == 0) {
                        allData = allData + line;
                        x++;
                    } else {
                        allData = allData + "\n" + line;
                    }

                }

                FileWriter writer = new FileWriter("Users/students.txt", false);
                writer.write(allData);
                writer.close();

            }
        }
    }

}
