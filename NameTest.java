public class NameTest {
    public static void main(String[] args) {
        NameTest underTest = new NameTest();

        underTest.createName();
        System.out.println("Test createName passed");

        underTest.testGetName();
        System.out.println("Test getName passed");

        underTest.testGetInitial();
        System.out.println("Test getInitial passed");

        underTest.testEquals();
        System.out.println("Test equals passed");

        System.out.println("All test passed!!!");
    }

    private void createName(){
        //Normal case 
        Name name = new Name("Tommy","Johnson");
        Assertions.assertNotNull(name);

        //Exceptional case
        try {
            final Name name2 = new Name(null, null);
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }

        //Exceptional case
        try {
            final Name name2 = new Name("James", null);
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }

        //Exceptional case
        try {
            final Name name2 = new Name("James", " ");
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }
    }
    private void testGetName(){
        
        Name name = new Name("Tommy","Johnson");
        Assertions.assertEquals("Tommy Johnson", name.getName());
    }

    private void testGetInitial(){

        Name name = new Name("Tommy","Johnson");
        Assertions.assertEquals("TJ", name.getInitial());
    }

    private void testEquals(){
        Name n1 = new Name("John", "Smith");
        Name n2 = new Name("Emma", "Taylor");
        Name n3 = new Name("Emma", "Taylor");

        Assertions.assertFalse(n1.equals(n2));
        Assertions.assertTrue(n2.equals(n3));

    }
}
