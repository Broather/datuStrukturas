package dataStr.SEMINARS_1.service;

import dataStr.SEMINARS_1.MyArrayListT;
import dataStr.SEMINARS_1.models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        MyArrayListT<Integer> intList = new MyArrayListT(4);

        File myObj = new File("dataStr/SEMINARS_1/numbers.txt");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int intTemp = Integer.parseInt(data);
                intList.pushBack(intTemp);
            }
            myReader.close();
            intList.print();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-----------------------");
        MyArrayListT<Student> studentList = new MyArrayListT<>(3);
        Student stud1 = new Student("Jānis", "Bērziņš");
        Student stud2 = new Student("Līga", "Jaukā");
        Student stud3 = new Student("Baiba", "Nejaukā");

        studentList.pushBack(stud1);
        studentList.pushBack(stud2);
        try {
            studentList.insert(stud3, 1);
            studentList.print();
            studentList.sort();
            studentList.print();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
