import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SmartCard {
    private  Name staffName;
    private  String dateOfBirth;
    private  SmartCardNumber s_num;
    private  Date dateOfIssue;
    private  String expiryDate;
    private  String status;

    SmartCard(Name staffName, String dateOfBirth, int yearOfIssue,String status) {
        this.staffName = staffName;
        this.dateOfBirth = dateOfBirth;
        this.s_num = new SmartCardNumber(staffName, yearOfIssue);
        this.dateOfIssue = new Date();
        this.status = status;
        setExpiryDate();
    }

    /**
     * Return staff's name
     * 
     * @return a Name object (staff's name)
     */
    public String getStaffName() {
        return staffName.getName();
    }

    /**
     * Return the birth date of staff
     * 
     * @return the date object(birth date of staff)
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Return the smart card number
     * 
     * @return a smartCardNumber object
     */
    public SmartCardNumber getNumber() {
        return s_num;
    }

    /**
     * Return the birth date of staff
     * 
     * @return the date object(date of issue)
     */
    public String getDateOfIssue() {
        return toString(dateOfIssue);
    }

    /**
     * set a expiry date for the card
     * If the smart card is held by a staff on fixed-term contract, the expiry date
     * is set to the issue
     * date plus two years. 
     * If the smart card is held by a staff on permanent
     * contract, the expiry date is set to the issue date plus ten years.
     * 
     * @param staff
     */
    private void setExpiryDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(dateOfIssue);
        if (getStaffStatus().equals("fixed")) {
            c.add(Calendar.YEAR, 2);
        } else if(getStaffStatus().equals("permanent")){
            c.add(Calendar.YEAR, 10);
        }
        expiryDate =toString( c.getTime());
    }
    
    /**
     * Return the date of expired
     * @return the date object(expiry date)
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Get the status of staff whether fied-term or permanent
     * @return String (fixed or permanent)
     */
    public String getStaffStatus(){
        for(Staff staff: StaffManager.staffList){
            SmartCard card = staff.getSmartCard();
            if(card.getStaffName().equals(staffName)){
                status =  staff.getStaffEmploymentStatus();
            }
        }
        return status;
    }

    public String toString(Date date ){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String strDate = simpleDateFormat.format(date);
       
        return strDate;
        
    }
    

}
