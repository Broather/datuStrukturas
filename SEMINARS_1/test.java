
import java.io.File; // Import the File class
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class test {
    public static void main(String[] args) throws Exception {
        MyArrayList list = new MyArrayList();

        File myObj = new File("SEMINARS_1/numbers.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            int data = myReader.nextInt();
            list.pushBack(data);
        }
        myReader.close();

        list.print();

        list.pushBack(100);
        list.print();
        list.insert(0, 100);
        list.print();
        System.out.println(list.retreve(0));
        list.print();
        System.out.println(Arrays.toString(list.find(100)));
        list.sort();
        list.print();
        list.clear();
        list.print();

    }
}
