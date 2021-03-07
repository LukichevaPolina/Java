import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, FileExcp {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name or path: ");
        String fileName = scan.nextLine();
        scan.close();


        File file = new File(fileName);
        if (file.length() == 0) {
            throw new FileExcp("empty file");
        }
        else {
            FileReader inpFile = new FileReader(file);
            CountLetter counter = new CountLetter();
            Map<Character, Integer> in = counter.toCount(inpFile);

            FileWriter outFile = new FileWriter("out.txt");
            for(Character key : in.keySet()) {
                Integer value = in.get(key);
                outFile.write(key + " - " + value + "\n");

            }
            outFile.close();
        }
    }
}
