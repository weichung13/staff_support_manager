import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

public class StaffManager  {

	// you can add attributes and other methods if needed.
	// you can throw an exception if needed

	public static ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	public static Set<Module> moduleList = new HashSet<>();
	public static Set<Name> studentList = new HashSet<>();
	

	/**
	 * This method should allow modules information to be read from a pre-defined
	 * data file (modules.txt, where path is the path to this file) and stored in a
	 * set of modules. The modules.TXT file contains one data entry per line with
	 * fields separated by a comma e.g. CSC8014, Software Development Advanced
	 * Techniques, 2, 10.
	 * 
	 * Module List provided
	 * 
	 * @param path
	 * @return a set of Module
	 */
	public Set<Module> readInModules(String path) {
		File file = new File(path);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String readModule = sc.nextLine();
				String[] module = readModule.split(",");
				String moduleCode = module[0].trim();
				String moduleName = module[1].trim();
				int semester = Integer.parseInt(module[2].trim());
				int credit = Integer.parseInt(module[3].trim());
				moduleList.add(new Module(moduleCode, moduleName, semester, credit));
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return moduleList;
	}

	/**
	 * This method should allow students information to be read from a pre-defined
	 * data file (Students.txt where path is the path to this file) and stored in a
	 * set of names. The Students.TXT file contains one data entry per line with
	 * fields separated by a space e.g. Charlie Chaplin
	 * 
	 * All students list
	 * @param path
	 * @return a set of Name
	 */
	public Set<Name> readInStudents(String path) {
		// add your code here. Do NOT change the method signature
		
		File file = new File(path);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String readStudents = sc.nextLine();
				String[] studentsName = readStudents.split(" ");
				String firstName = studentsName[0];
				String lastName = studentsName[1];
				studentList.add(new Name(firstName, lastName));
			}
			sc.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return studentList;
	}

	/**
	 * This method returns the number of staff of the specified type (a lecturer or
	 * a researcher) that are currently employed.
	 * 
	 * @param type
	 * @return the number of staffs
	 */
	public int noOfStaff(String type) {
		// add your code here. Do NOT change the method signature
		int count = 0;

		for (Staff s : staffList) {
			if (s.getStaffType().equals(type)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * This method adds either a set of modules or a set of students to the staff depending on their type. 
	 * You need to make sure that modules and students are valid before assigning them to the staff 
	 * (This can be done by comparing the set against the records of existing students and modules).
	 * Return Whether it is added or not
	 * @param id
	 * @param modules
	 * @param students
	 * @return true if is added
	 */
	public boolean addData(StaffID id, Set<Module> modules, Set<Name> students) {	

		boolean isModuleValid = false;
		int countM = 0;
		for(Module m1:moduleList){
			for(Module m2 : modules){
				if(m1.equals(m2)){
					countM++;
				}
			}
		}
		if(countM == modules.size()){
			isModuleValid =  true;
		}

		boolean isStudentValid = false;
		int countS = 0;
		for(Name n1:studentList){
			for(Name n2 : students){
				if(n1.equals(n2)){
					countS++;
				}
			}
		}
		if(countS == students.size()){
			isStudentValid =  true;
		}

		for (Staff staff : staffList) {
			if (staff.getStaffID().equals(id)) {
				if (staff instanceof Lecturer && isModuleValid) {
					((Lecturer) staff).assign(modules);
					return true;
				} else if (staff instanceof Researcher && isStudentValid) {
					((Researcher) staff).assign(students);
					return true;
				}
			}
		}
		return false;
		
	}



	/**
	 * This method registers a new staff onto the system and allocates a smart card
	 * and a staff ID (see below for additional rules about whether or not a smart
	 * card can be issued). On success, this method needs to return a Staff object.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param staffType
	 * @param employmentStatus
	 * @return a Staff object
	 */
	public Staff employStaff(String firstName, String lastName, Date dob, String staffType, String employmentStatus) {
		// add your code here. Do NOT change the method signature

		Calendar DateOfBirth = Calendar.getInstance();

		DateOfBirth.setTime(dob);

		final int yob = DateOfBirth.get(Calendar.YEAR);
		final int mob = DateOfBirth.get(Calendar.MONTH);
		final int day = DateOfBirth.get(Calendar.DATE);

		final LocalDate now = LocalDate.now();
		final LocalDate birth = LocalDate.of(yob, mob, day);

		// Check if the staff's age is between 22 ~ 67
		if (Period.between(birth, now).getYears() >= 22 && Period.between(birth, now).getYears() < 68) {
			Calendar current = Calendar.getInstance();

			String pattern = "MM-dd-yyyy";
     		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        	String strDate = simpleDateFormat.format(dob);

			// Get the current year to set up SmartCardNumber
			int currentYear = current.get(Calendar.YEAR);

			Name newStaff = new Name(firstName, lastName);

			SmartCard newCard = new SmartCard(newStaff, strDate, currentYear,employmentStatus);

			StaffID newID = new StaffID();

			Staff staff;
			if (staffType.equals("lecturer")) {
				staff = new Lecturer(newCard, newID);
			} else if (staffType.equals("researcher")) {
				staff = new Researcher(newCard, newID);
			} else {
				throw new IllegalArgumentException("Invalid staff type!");
			}

			staffList.add(staff);
			return staff;
		} else {
			return null;
		}
	}

	/**
	 * This method returns all staff that are employed by the university.
	 * @return a list of all the staffs
	 */
	public Collection<Staff> getAllStaff() {
		// add your code here. Do NOT change the method signature
		return staffList;
	}


	/**
	 * This method removes the staff record associated with the given staff id. In effect, the staff is leaving the University.
	 * @param id
	 */
	public void terminateStaff(StaffID id) {
		// add your code here. Do NOT change the method signature
		for(Staff s: staffList){
			if(s.getStaffID().equals(id)){
				staffList.remove(s);
			}
		}

	}

}
