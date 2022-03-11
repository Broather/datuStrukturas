package dataStr.SEMINARS_1.service;

import dataStr.SEMINARS_1.MyArrayListT;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainService {
    public static void main(String[] args) {
        MyArrayListT intList = new MyArrayListT(4);

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
    }
}
