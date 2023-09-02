
import java.util.HashSet;
import java.util.Set;

public class Researcher extends StaffFactory {
    private Set<Name> students = new HashSet<>();
    
    Researcher(SmartCard smartCard,StaffID staffID){
        super(smartCard, staffID,"researcher");
        this.students = new HashSet<>();
    }

    /**
     * assign a set of students to researcher
     * @param set
     */
    public void assign(Set<Name> set){
        students.addAll(set);
    }

    /**
	 * Return the list of students who are supervised by a researcher
	 * @return a list of type Name
	 */
    public Set<Name> getStudents(){
        return students;
    }


    /**
	 * Return true if the researcher is currently supervising enough students (10 in total) and false otherwise.
	 * @return True if supervise enough student, otherwise return false
	 */
    public boolean enoughStudent(){
        return getStudents().size()==10;
    }
}
