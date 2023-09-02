import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SmartCardNumber {
    private static  Map<String,Boolean> map  = new HashMap<String,Boolean>();
    private String initial;
    private int yearOfIssue;
    private int serialNum;
    
    public SmartCardNumber(Name name,int yearOfIssue){
        this.initial = name.getInitial();
        this.yearOfIssue = yearOfIssue;
        generateNum();
    }

    /**
     * Get the SmartCardNUmber with the correct formmat : JS-10-2023
     * @return A formmat String
     */
    public String getCardNum(){
        return String.format("%s-%02d-%d", initial, serialNum, yearOfIssue);
    }

    /**
     * Generate a unique random serial number
     * @return Random 2 digits integer
     */
    private void generateNum(){
        Random randomDigits = new Random();
        serialNum = randomDigits.nextInt(100);

        while(map.containsKey(getCardNum())){
            serialNum = randomDigits.nextInt(100);
        }
        boolean isUnique = true;
        map.put(getCardNum(),isUnique);
    }

    public int getSerialNum(){
        return serialNum;
    }
}
