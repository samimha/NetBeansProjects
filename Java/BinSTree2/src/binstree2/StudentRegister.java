/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binstree2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Sami
 */
public class StudentRegister implements Serializable {

    private TreeSet tree;

    public StudentRegister() {
        tree = new TreeSet();
    }

    public void add(String firstName, String lastName, int age, float avgGrade) {
        tree.add(new Student(firstName, lastName, age, avgGrade));
    }

    public String list() {
        return tree.toString();
    }

    public void save() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("file.ser");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.close();
    }

    private class Student implements Comparable<Student>, Serializable {

        private String firstName;
        private String lastName;
        private int age;
        private float avgGrade;

        public Student(String firstName, String lastName, int age, float avgGrade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.avgGrade = avgGrade;
        }

        @Override
        public int compareTo(Student s) {
            return s.lastName.compareTo(this.lastName);
        }

        public String toString() {
            return firstName + " " + lastName + " - age: " + age + " - avg grade: " + avgGrade;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        StudentRegister bintree = new StudentRegister();

        System.out.println(bintree.list());

        loopy: while (true) {
            System.out.println("Commands: \n* ADD\n* LIST\n* SAVE\n* LOAD\n* EXIT");
            String command = s.nextLine();
            switch (command) {
                case "add":
                    System.out.println("Enter first name: ");
                    String firstName = s.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = s.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(s.nextLine());
                    System.out.println("Enter average grade: ");
                    float avg = s.nextFloat();
                    bintree.add(firstName, lastName, age, avg);
                    System.out.println("\nStudent added");
                    break;
                case "list":
                    System.out.println(bintree.list());
                    break;
                case "save":
                    bintree.save();
                    System.out.println("Students saved");
                    break;
                case "load":
                    //load
                    FileInputStream fis = new FileInputStream("file.ser");
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    bintree = (StudentRegister) ois.readObject();
                    ois.close();
                    break;
                case "exit":
                    System.out.println("Byeeee!");
                    break loopy;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

}
