public class SmartCardNumberTest {
    public static void main(String[] args) {
        SmartCardNumberTest underTest = new SmartCardNumberTest();
        underTest.createNumber();
        System.out.println("Test createNumber passed");

        underTest.testGetCardNum();
        System.out.println("Test getCardNum passed");
        System.out.println("Test getserialNum passed");

        underTest.testGenerateNum();
        System.out.println("Test generateNum passed");
        System.out.println("All test passed!!!");
    }
     
    public void createNumber(){
        Name name = new Name("John", "Smith");
        SmartCardNumber cardNum = new SmartCardNumber(name, 2023);

        Assertions.assertNotNull(cardNum);
    }

    public void testGetCardNum() {
        // create a new SmartCardNumber
        Name name = new Name("John", "Smith");
        SmartCardNumber cardNum = new SmartCardNumber(name, 2023);

        Assertions.assertNotNull(cardNum.getCardNum());
        // test that the generated card number matches the expected format
        Assertions.assertEquals("JS-" + cardNum.getSerialNum() + "-2023", cardNum.getCardNum());
    }

    public void testGenerateNum() {
        // create two SmartCardNumber objects with the same name and year of issue
        Name name = new Name("John", "Smith");
        SmartCardNumber cardNum1 = new SmartCardNumber(name, 2023);
        SmartCardNumber cardNum2 = new SmartCardNumber(name, 2023);


        // test that the generated serial numbers are unique
        Assertions.assertNotEquals(cardNum1.getCardNum(), cardNum2.getCardNum());
    }
}
   


