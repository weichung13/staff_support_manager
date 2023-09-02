import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LecturerTest {
    public static void main(String[] args) {
        LecturerTest underTest = new LecturerTest();

        underTest.testGetInfos();
        System.out.println("Test all getters passed");

        underTest.testMethods();

        System.out.println("All tests passed!!!");

    }

    private void testGetInfos(){
        Name name = new Name("James", "Silva");

        Calendar dob = Calendar.getInstance();
        dob.set(1999, Calendar.JANUARY, 3);
        Date dateOfBirth = dob.getTime();
        
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(dateOfBirth);
        
        SmartCard card = new SmartCard(name, strDate, 2023, "fixed");
        StaffID id = new StaffID();
        Lecturer lecturer = new Lecturer(card, id);

        //test create lecturer
        Assertions.assertNotNull(lecturer);

        //test getStaffID
        Assertions.assertEquals(id, lecturer.getStaffID());
        System.out.println("Test getStaffID passed");

        //test getSmartCard
        Assertions.assertEquals(card, lecturer.getSmartCard());
        System.out.println("Test getSmartCard passed");

        //test getStaffEmploymentStatus
        Assertions.assertEquals("fixed", lecturer.getStaffEmploymentStatus());
        System.out.println("Test getStaffEmploymentStatus passed");

        //test getStaffType
        Assertions.assertEquals("lecturer", lecturer.getStaffType());
        System.out.println("Test getStaffType passed");
    }
    

    private void testMethods(){
        Name name = new Name("James", "Silva");

        Calendar dob = Calendar.getInstance();
        dob.set(1999, Calendar.JANUARY, 3);
        Date dateOfBirth = dob.getTime();
        
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(dateOfBirth);
        
        SmartCard card = new SmartCard(name, strDate, 2023, "fixed");
        StaffID id = new StaffID();
        Lecturer lecturer = new Lecturer(card, id);
        

        Module m1 = new Module("CSC8011", "Introduction to Software Development", 1, 10);
        Module m2 = new Module("CSC8012", "Software Development Techniques and Tools", 1, 10);
        Module m3 = new Module("CSC8019", "Software Engineering and Team Project", 2, 20);

        Set<Module> modules = new HashSet<Module>();
        modules.add(m1);
        modules.add(m2);
        
        //test assign
        lecturer.assign(modules);
        System.out.println("Test assign passed");

        //test getModule
        Assertions.assertNotNull(lecturer.getModules());
        System.out.println("Test getModule passed");

        //test enoughCredit passed
        Assertions.assertFalse(lecturer.enoughCredit());

        lecturer.getModules().add(m3);
        Assertions.assertTrue(lecturer.enoughCredit());

        System.out.println("Test enoughCredit passed");
        
    }


}
