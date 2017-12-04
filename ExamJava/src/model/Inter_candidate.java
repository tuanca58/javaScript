/**
 * 
 */
package model;

import java.util.List;
import java.util.Scanner;

import util.Validate;
import bus.InterBus;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+1:58:03 PM
 */
public class Inter_candidate extends Candidate {
	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	private String majors;
	private int semester;
	private String university_name;

	/**
	 * Descaption User Nov 28, 2017
	 */
	public Inter_candidate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Descaption User
	 * 
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param address
	 * @param phone
	 * @param email
	 * @param type
	 *          Nov 28, 2017
	 */
	public Inter_candidate(String firstname, String lastname, int birthdate,
			String address, String phone, String email, int type, String majors,
			int semester, String university_name) {
		super(firstname, lastname, birthdate, address, phone, email, type);
		this.majors = majors;
		this.semester = semester;
		this.university_name = university_name;
	}

	public static void input() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Number Inter Input: ");
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				Inter_candidate ic = new Inter_candidate();
				System.out.println("User " + (i + 1));
				System.out.println("First name: ");
				ic.setFirstName(sc.next());
				System.out.println("Last Name: ");
				ic.setLastName(sc.next());
				System.out.println("Birth date (YYYY-int): ");
				int date;
				date = sc.nextInt();
				//check date input
				while (date < 1900 || date > 2018) {
					System.out.println("Wrong type Date ! ");
					System.out.println("Birth date (YYYY-int): ");
					date = sc.nextInt();
				}
				ic.setBirthDate(date);
				System.out.println("Address: ");
				ic.setAddress(sc.next());
				System.out.println("Phone: ");
				String phone;
				phone = sc.next();
				///check phonenumber input
				while ((Integer.parseInt(phone) < 1000000)) {
					System.out.println("Phone: ");
					System.out.println("Min 7 number !");
					phone = sc.next();
				}
				ic.setPhone(phone);
				System.out.println("Email: ");
				String email;
				email = sc.next();
				///check email input
				while (!Validate.isEmail(email)) {
					System.out.println("Email: ");
					System.out.println("Wrong type Email !");
					email = sc.next();
				}
				ic.setEmail(email);
				ic.setCandidate_type(2);
				System.out.println("Majors: ");
				ic.setMajors(sc.next());
				System.out.println("Semester(number): ");
				ic.setSemester(sc.nextInt());
				System.out.println("University name: ");
				ic.setUniversity_name(sc.next());

				if (InterBus.insertInter(ic)) {
					System.out.println("Insert User Success !");
				} else {
					System.out.println("Insert User Fail !");
				}
				sc.close();
			}
		} catch (Exception e) {
			System.out.println("Number only !");
		}
	}

	/**Descaption
	 *User
	 *Nov 28, 2017
	 */
	public void getList() {
		List<Inter_candidate> list = InterBus.getListInter();
		for (Inter_candidate user : list) {
			System.out.println("------------------------------------------------");
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Birth date: " + user.getBirthDate());
			System.out.println("Address: " + user.getAddress());
			System.out.println("Phone: " + user.getPhone());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Candidate type: Intern");
			System.out.println("Majors: " + user.getMajors());
			System.out.println("Semester: " + user.getSemester());
			System.out.println("University name: " + user.getUniversity_name());
		}
	}

}
