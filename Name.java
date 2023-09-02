import java.util.Objects;

public class Name extends StaffManager{
    private String firstName;
    private String lastName;
    Name(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Return the name
     * @return a String(name of staff or student)
     */
    public String getName(){
        return firstName + " " + lastName;
    }

    /**
     * Get the initial of the name
     * @return A String of name initial
     */
    public String getInitial(){
        return firstName.substring(0,1)+lastName.substring(0,1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name other = (Name) obj;
        return Objects.equals(firstName, other.firstName)&& Objects.equals(lastName, other.lastName);
    }

 


    
}
