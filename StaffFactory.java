import java.util.HashMap;
import java.util.Map;

public abstract class StaffFactory implements Staff{
    public static final String LECTURER = "lecturer";
    public static final String RESEARCHER = "researcher";
    public static final String FIXED = "fixed";
    public static final String PERMANENT = "permanent";
    private static final Map<StaffID,Staff>staffs = new HashMap<StaffID,Staff>();
    private final SmartCard smartCard;
    private final StaffID staffID;
    private final String staffType;

    StaffFactory(SmartCard smartCard,StaffID staffID,String staffType){
        this.smartCard = smartCard;
        this.staffID = staffID;
        this.staffType = staffType; 
    }

    public static Staff getInstance(SmartCard smartCard,StaffID staffID,String type){

        Staff s = staffs.get(staffID);

        if(s!=null)return s;

        if(type.equals(LECTURER)){
            s =  new Lecturer(smartCard,staffID);
        }else if(type.equals(RESEARCHER)){
            s =  new Researcher(smartCard,staffID);
        }

        staffs.put(staffID,s);
        return s;
    }

    public StaffID getStaffID(){
        return staffID;
    }
	
	public SmartCard getSmartCard(){
        return smartCard;
    }

	public String getStaffEmploymentStatus(){
        return getSmartCard().getStaffStatus();
    }
	
    public String getStaffType(){
        return staffType;
    }

    
    
}
