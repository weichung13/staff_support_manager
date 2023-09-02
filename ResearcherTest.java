import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResearcherTest {
    public static void main(String[] args) {
        ResearcherTest underTest = new ResearcherTest();

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
        Researcher researcher = new Researcher(card, id);

        //test create lecturer
        Assertions.assertNotNull(researcher);

        //test getStaffID
        Assertions.assertEquals(id, researcher.getStaffID());
        System.out.println("Test getStaffID passed");

        //test getSmartCard
        Assertions.assertEquals(card, researcher.getSmartCard());
        System.out.println("Test getSmartCard passed");

        //test getStaffEmploymentStatus
        Assertions.assertEquals("fixed", researcher.getStaffEmploymentStatus());
        System.out.println("Test getStaffEmploymentStatus passed");

        //test getStaffType
        Assertions.assertEquals("researcher", researcher.getStaffType());
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
        Researcher researcher = new Researcher(card, id);
        

        Name n1 = new Name("Jack", "Grayson");
        Name n2 = new Name("John", "Smith");
        Name n3 = new Name("Emma", "Steve");
        Name n4 = new Name("Sam", "Brown");
        Name n5 = new Name("Sammy", "Brooks");
        Name n6 = new Name("Lam", "Owens");
        Name n7 = new Name("Adam", "Winter");
        Name n8 = new Name("Springer", "Ness");
        Name n9 = new Name("Mose", "Ivan");
        Name n10 = new Name("Rose", "Jeter");

        Set<Name> students = new HashSet<Name>();
        
        students.add(n1);
        students.add(n2);
        students.add(n3);
        students.add(n4);
        students.add(n5);
        students.add(n6);
        students.add(n7);
        students.add(n8);
        students.add(n9);
        students.add(n10);
        
        //test assign
        researcher.assign(students);
        System.out.println("Test assign passed");

        //test getModule
        Assertions.assertNotNull(researcher.getStudents());
        System.out.println("Test getStudents passed");

        //test enoughCredit 
        Assertions.assertTrue(researcher.enoughStudent());

        researcher.getStudents().clear();
        Assertions.assertFalse(researcher.enoughStudent());

        System.out.println("Test enoughStudent passed");
        
    }

}
