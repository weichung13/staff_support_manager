public class ModuleTest {
    public static void main(String[] args) {
        ModuleTest underTest = new ModuleTest();

        underTest.createModule();
        System.out.println("Test createModule passed");

        underTest.testGetSemester();
        System.out.println("Test getSemester passed");

        underTest.testGetCredit();
        System.out.println("Test getCredit passed");

        underTest.testGetCode();
        System.out.println("Test getCode passed");

        underTest.testGetModuleName();
        System.out.println("Test getModuleName passed");

        underTest.testEquals();
        System.out.println("Test equals passed");

        System.out.println("All tests passed!!!");
    }

    private void createModule(){
        //Normal case
        Module module = new Module("CSC8014", "Software Development Advanced Techniques", 2, 10);
        Assertions.assertNotNull(module);

        //Exceptional case
        try {
            final Module module2 = new Module(null, null, 1, 10);
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }

         //Exceptional case
         try {
            final Module module2 = new Module("CSC8014", " ", 1, 10);
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }

         //Exceptional case
         try {
            final Module module2 = new Module(" ", "Software Development Advanced Techniques", 1, 10);
        } catch (Exception e) {
            Assertions.assertExpectedThrowable(NullPointerException.class, e);
        }
    }

    private void testGetSemester(){
        Module module = new Module("CSC8014", "Software Development Advanced Techniques", 2, 10);
        Assertions.assertEquals(2, module.getSemester());
    }

    
    private void testGetCredit(){
        Module module = new Module("CSC8014", "Software Development Advanced Techniques", 2, 10);
        Assertions.assertEquals(10, module.getCredit());
    }

    
    private void testGetCode(){
        Module module = new Module("CSC8014", "Software Development Advanced Techniques", 2, 10);
        Assertions.assertEquals("CSC8014", module.getCode());;
    }


    private void testGetModuleName(){
        Module module = new Module("CSC8014", "Software Development Advanced Techniques", 2, 10);
        Assertions.assertEquals("Software Development Advanced Techniques", module.getModuleName());
    }

    private void testEquals(){
        Module m1 = new Module("CSC8011", "Introduction to Software Development", 1, 10);
        Module m2 = new Module("CSC8012", "Software Development Techniques and Tools", 1, 10);
        Module m3 = new Module("CSC8011", "Introduction to Software Development", 1, 10);

        Assertions.assertFalse(m1.equals(m2));
        Assertions.assertTrue(m1.equals(m3));

    }
}
