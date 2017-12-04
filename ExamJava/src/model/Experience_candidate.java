/**
 * 
 */
package model;

import java.util.List;
import java.util.Scanner;

import util.Validate;
import bus.ExperienceBus;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+1:45:08 PM
 */
public class Experience_candidate extends Candidate {
	 int expInYear;

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	String proSkill;

	/**
	 * Descaption User Nov 28, 2017
	 */
	public Experience_candidate() {
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
	public Experience_candidate(String firstname, String lastname, int birthdate,
			String address, String phone, String email, int type, int expInYear,
			String proSkill) {
		super(firstname, lastname, birthdate, address, phone, email, type);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public static void input() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Number Experience Input: ");
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				Experience_candidate ec = new Experience_candidate();
				System.out.println("User " + (i + 1));
				System.out.println("First name: ");
				ec.setFirstName(sc.next());
				System.out.println("Last Name: ");
				ec.setLastName(sc.next());
				System.out.println("Birth date (YYYY-int): ");
				int date;
				date = sc.nextInt();
				while (date < 1900 || date > 2018) {
					System.out.println("Wrong type Date ! ");
					System.out.println("Birth date (YYYY-int): ");
					date = sc.nextInt();
				}
				ec.setBirthDate(date);
				System.out.println("Address: ");
				ec.setAddress(sc.next());
				System.out.println("Phone: ");
				String phone;
				phone = sc.next();
				while ((Integer.parseInt(phone) < 1000000)) {
					System.out.println("Min 7 number !");
					System.out.println("Phone: ");
					phone = sc.next();
				}
				ec.setPhone(phone);
				System.out.println("Email: ");
				String email;
				email = sc.next();
				while (!Validate.isEmail(email)) {
					System.out.println("Wrong type Email !");
					System.out.println("Email: ");
					email = sc.next();
				}
				ec.setEmail(email);
				ec.setCandidate_type(0);
				System.out.println("Expin year(int): ");
				int exp;
				exp = sc.nextInt();
				while (exp < 0 || exp > 101) {
					System.out.println("exp >0 and <100!");
					System.out.println("Expin year(int): ");
					exp = sc.nextInt();
				}
				ec.setExpInYear(exp);
				System.out.println("Pro Skill(String): ");
				ec.setProSkill(sc.next());

				if (ExperienceBus.insertExperience(ec)) {
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

	public void getList() {
		List<Experience_candidate> list = ExperienceBus.getListExperience();
		for (Experience_candidate user : list) {
			System.out.println("------------------------------------------------");
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Birth date: " + user.getBirthDate());
			System.out.println("Address: " + user.getAddress());
			System.out.println("Phone: " + user.getPhone());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Candidate type: Experience");
			System.out.println("Expin year: " + user.getExpInYear());
			System.out.println("Pro Skill: " + user.getProSkill());

		}
	}
}
