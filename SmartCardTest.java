import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartCardTest {
    public static void main(String[] args) {
        SmartCardTest underTest = new SmartCardTest();

        underTest.createSmartCard();
        System.out.println("Test createSmartCard passed");

        underTest.testGetInfos();
        System.out.println("Test all getters passed");
        System.out.println("All test passed!!!");

    }
    
    private void createSmartCard() {
        Name name = new Name("Ken", "Smith");

        Calendar dob = Calendar.getInstance();
        dob.set(1999, Calendar.JANUARY, 3);
        Date dateOfBirth = dob.getTime();
        
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(dateOfBirth);

        SmartCard card = new SmartCard(name,strDate, 2023,"fixed");

        Assertions.assertNotNull(card);
    }

    private void testGetInfos(){
        Name name = new Name("Ken", "Smith");
        String status = "fixed";

        Calendar dob = Calendar.getInstance();
        dob.set(1999, Calendar.JANUARY, 3);
        Date dateOfBirth = dob.getTime();
        
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(dateOfBirth);

        SmartCard card = new SmartCard(name,strDate, 2023,status);

        

        //test getStaffName
        Assertions.assertEquals("Ken Smith", card.getStaffName());
        System.out.println("Test getStaffName passed");

        //test getDateOfBirth
        Assertions.assertEquals("01-03-1999", card.getDateOfBirth());
        System.out.println("Test getDateOfBirth passed");

        //test getNumber
        Assertions.assertNotNull(card.getNumber());
        System.out.println("Test getNumber passed");
        
        //test getDateOfIssue
        Date currentDate = new Date();
        Assertions.assertNotEquals(currentDate, card.getDateOfIssue());
        System.out.println("Test getDateOfIssue passed");

        //test setExpiryDate and getExpiryDate
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR,2);
        Date expiryDate = c.getTime();
        
        Assertions.assertEquals(card.toString(expiryDate), card.getExpiryDate());
        System.out.println("Test setExpiryDate and getExpiryDate passed");

        //test getStaffStatus
        Assertions.assertEquals("fixed", card.getStaffStatus());
        System.out.println("Test getStaffStatus passed");
    }


    

    


   
}
