
import java.util.HashSet;
import java.util.Set;

public class Lecturer extends StaffFactory{
    private Set<Module>modules = new HashSet<Module>();
    
    Lecturer(SmartCard smartCard,StaffID staffID){
        super(smartCard, staffID, "lecturer");
        this.modules = new HashSet<>();
    }

    /**
     * Assign a module to the lecturer
     * @param set
     */
    public void assign(Set<Module> set){
        modules.addAll(set);
    }

     /**
	 * Return the list of modules that are taught by a lecturer
	 * @return a list of type Name
	 */
    public Set<Module> getModules(){
        return modules;
    }

    /**
	 * Return true if the lecturer is currently teaching enough credits (40 credits in both semester) and false otherwise.
     * can be : 0/40,10/30,20/20
	 * @return True if credit is enough, otherwise return false
	 */
    public boolean enoughCredit(){
        int totalCredit = 0;
        for(Module m :modules){
            totalCredit += m.getCredit();
        }
        if(totalCredit <40){
            return false;
        }else{
            return true;
        }
    }

   

   
}
