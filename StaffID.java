import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StaffID {
    static final Map<String,StaffID> map = new HashMap<String,StaffID>();
    private final String letter;
    private final String digits;
    private final String strID; 
    
    public StaffID(){
        this.letter = generateLetter();
        this.digits = generateDigits();
        this.strID = getID();
    }

    /**
     * Generate a random letter
     * @return String a letter
     */
    public static String generateLetter(){
        String alphabet = "abcdefghijklmonpqrstuvwxyz";
        Random randomLetter = new Random();
        char ch = alphabet.charAt(randomLetter.nextInt(alphabet.length()));

        String strLetter = String.valueOf(ch);

        return strLetter;
    }

    /**
     * Generate a random 3 digits number
     * @return String 3 digits number
     */
    public static String generateDigits(){
        Random randomDigits = new Random();
        int digits = randomDigits.nextInt(1000);
        String strDigits = String.format("%03d", digits);

        return strDigits;
    }

    public static StaffID getInstance(String letter,String digits){
        String strID = letter + digits;
        StaffID id = map.get(strID);
        if(id == null){
            id = new StaffID();
            map.put(strID, id);
        }
        return id;
    }

    /**
     * Return the letter
     * @return a String(the letter of ID)
     */
    public String getLetter(){
        return letter;
    }

    /**
     * Return 3 digits number
     * @return a integer(3 digits number)
     */
    public String getDigits(){
        return digits;
    }

    /**
     * Return StaffID
     * @return a String(letter + 3 digits number)
     */
    public String getID(){
        return letter + digits;
    }


}
