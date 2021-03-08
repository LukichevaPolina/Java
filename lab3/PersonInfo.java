import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class PersonInfo {
    String surname;
    String name;
    String middle_name;
    String d_birth;
    String inicials;
    Long age;
    Character sex;
    public PersonInfo(String info)
    {
        try {
            String[] words = info.split(" ");
            surname = words[0];
            d_birth = words[3];
            inicials = words[1].charAt(0) + ". " + words[2].charAt(0) + ".";

            //age
            String[] birth = d_birth.split(Pattern.quote("."));
            Calendar date = new GregorianCalendar();
            Calendar birthday = new GregorianCalendar(Integer.parseInt(birth[2]), Integer.parseInt(birth[1]), Integer.parseInt(birth[0]));
            age = (date.getTimeInMillis() - birthday.getTimeInMillis()) / 1000 / 60 / 60 / 24 / 365;

            //sex
            if (words[2].charAt(words[2].length() - 1) == 'a') {
                sex = 'F';
            } else {
                sex = 'M';
            }
        }
        catch (Exception e) {
            System.out.print ("*** wrong input ***");
        }

    }

    public String getSurname()
    {
        return surname;
    }

    public String getInicials()
    {
        return inicials;
    }

    public Long getAge()
    {
        return age;
    }

    public void printInfo()
    {
        System.out.println(surname + " " + inicials + " " + sex + " " + age);
    }

}
