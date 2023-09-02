import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class StaffManagerTest {
    public static void main(String[] args) {
        StaffManagerTest underTest = new StaffManagerTest();

        underTest.test();
        System.out.println("All test passed!!!");

    }
    private void test(){
        StaffManager manager = new StaffManager();

        //test readInModules and readInStudents
        Set<Module>moduleList = manager.readInModules("modules.TXT");
        Assertions.assertNotNull(moduleList);
        System.out.println("Test readInModules passed");

        Set<Name> studentList = manager.readInStudents("students.TXT");
        Assertions.assertNotNull(studentList);
        System.out.println("Test readInStudents passed");
        

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, 1998);
        c1.set(Calendar.MONTH, Calendar.APRIL);
        c1.set(Calendar.DAY_OF_MONTH, 16);
        Date dob1 = c1.getTime();
    
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.YEAR, 1987);
        c2.set(Calendar.MONTH, Calendar.AUGUST);
        c2.set(Calendar.DAY_OF_MONTH, 27);
        Date dob2 = c2.getTime();
        

        Calendar c3 = Calendar.getInstance();
        c3.set(Calendar.YEAR, 2020);
        c3.set(Calendar.MONTH, Calendar.MARCH);
        c3.set(Calendar.DAY_OF_MONTH, 15);
        Date dob3 = c3.getTime();
        

        Staff staff1 = manager.employStaff("James", "Robin",dob1 , "lecturer", "fixed");
        Staff staff2 = manager.employStaff("Polly", "Boris", dob2, "researcher", "permanent");
        //test employStaff
        Assertions.assertNotNull(staff1);
        Assertions.assertNotNull(staff2);

        Staff staff3 = manager.employStaff("Ken", "Cheng", dob3, "lecturer", "permanent");
        //Age under 22 return null
        Assertions.assertNull(staff3);
        
        System.out.println("Test employStaff passed");

        //test getAllStaff
        Assertions.assertNotNull(manager.getAllStaff());
        System.out.println("Test getAllStaff passed");

        //test noOfStaff
        Assertions.assertEquals(1, manager.noOfStaff("lecturer"));
        Assertions.assertEquals(1, manager.noOfStaff("researcher"));

        System.out.println("Test noOfStaff passed");

        //test addData

        Set<Module> set1 = new HashSet<>();
        Module m1 = new Module("CSC8011", "Introduction to Software Development", 1, 10);
        Module m2 = new Module("CSC8012", "Software Development Techniques and Tools", 1, 10);
 
       
        set1.add(m1);
        set1.add(m2);

        Set<Name> set2 = new HashSet<>();
        Name n1 = new Name("John", "Smith");
        Name n2 = new Name("Emma", "Taylor");

        set2.add(n1);
        set2.add(n2);

        Assertions.assertTrue(manager.addData(staff1.getStaffID(), set1, set2));
        Assertions.assertTrue(manager.addData(staff2.getStaffID(), set1, set2));
        

        System.out.println("Test addData passed");

        //test terminate
        manager.terminateStaff(staff1.getStaffID());
        Assertions.assertFalse(manager.getAllStaff().contains(staff1));

        System.out.println("Test terminateStaff passed");


    }
}
