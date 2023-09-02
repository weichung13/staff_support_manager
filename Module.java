import java.util.Objects;

public class Module {
    private String moduleCode;
    private String moduleName;
    private int semester;
    private int credit;
    Module(String moduleCode,String moduleName,int semester,int credit){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.semester = semester;
        this.credit = credit;
    }

    /**
     * Get which semester this module is 
     * @return Integer semester
     */
    public int getSemester(){
        return semester;
    }

    /**
     * Get how many credits this module is
     * @return Integer credits
     */
    public int getCredit(){
        return credit;
    }

    /**
     * Get the code of this module
     * @return A String of the code
     */
    public String getCode(){
        return moduleCode;
    }

    /**
     * Get the name of this module
     * @return A string of module name
     */
    public String getModuleName(){
        return moduleName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Module)) {
            return false;
        }
        Module other = (Module) obj;
        return Objects.equals(moduleCode, other.moduleCode)&& Objects.equals(moduleName, other.moduleName)&& semester == other.semester&& credit == other.credit;
    }


}
