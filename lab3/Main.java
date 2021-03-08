import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter information separated by spaces (surname name middle-name d-birth [DD.MM.YYYY]):");
        String person_str = scan.nextLine();
        scan.close();

        PersonInfo person = new PersonInfo(person_str);
        person.printInfo();
    }
}
