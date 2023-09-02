public class StaffIDTest {
    public static void main(String[] args) {
        StaffIDTest underTest = new StaffIDTest();

        underTest.createStaffID();
        System.out.println("Test createStaffID passed");

        underTest.testGenerateLetter();
        System.out.println("Test generateLetter passed");

        underTest.testGenerateDigits();
        System.out.println("Test generateDigits passed");

        underTest.testGetInstance();
        System.out.println("Test getInstance passed");

        underTest.testGetInfo();
        System.out.println("Test getInfo passed");

        System.out.println("All tests passed!!!");
    
    }

    private void createStaffID(){
        StaffID id = new StaffID();
        Assertions.assertNotNull(id);
    }

    private void testGenerateLetter(){
        String alphabet = "abcdefghijklmonpqrstuvwxyz";
        String letter = StaffID.generateLetter();
        Assertions.assertTrue(alphabet.contains(letter));
        Assertions.assertNotNull(letter);
    }

   
    private void testGenerateDigits(){
        StaffID id = new StaffID();
        String digits = StaffID.generateDigits();
        Assertions.assertTrue(digits.matches("\\d{3}"));
        Assertions.assertNotNull(id);
    }

    private void testGetInstance(){

        StaffID id1 = StaffID.getInstance("a", "123");
        StaffID id2 = StaffID.getInstance("b", "456");
        StaffID id3 = StaffID.getInstance("a", "123");

        Assertions.assertNotEquals(id1, id2);
        Assertions.assertEquals(id1, id3);

    }

    private void testGetInfo(){
        StaffID id = new StaffID();
        Assertions.assertEquals(id.getID(),id.getLetter()+id.getDigits());
    }

    
}
