package ge.tsu;
import ge.tsu.FilterClass.FilterClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Launcher {
    public static void main(String[] args) {
        // Lets create list of Certificate and add some valid and invalid data
        List<Certificate> cerList = new ArrayList<>();
        cerList.add(new DigitalCertificate("English C1", LocalDate.now().minusYears(2),LocalDate.now()));
        cerList.add(new PaperCertificate("English B2", LocalDate.now(), LocalDate.now().minusYears(2)));
        cerList.add(new DigitalCertificate("Java(OOP)", LocalDate.now().minusYears(1),LocalDate.now().plusYears(5)));
        cerList.add(new PaperCertificate("C++(KING)", LocalDate.now(),LocalDate.now()));
        cerList.add(new DigitalCertificate(".Net", LocalDate.now(),LocalDate.now().plusYears(5)));
        cerList.add(new PaperCertificate("TypeSript", LocalDate.now(),LocalDate.now()));
        // Call FilterClass static Sorter method
        Map<Status, List<Certificate>> sortedInfo = FilterClass.Sorter(cerList);
        // Print sortedInfo
        System.out.println(sortedInfo);
    }
}
