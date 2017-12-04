/**
 * 
 */
package model;

import java.util.List;
import java.util.Scanner;

import util.Validate;
import bus.FresherBus;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+1:54:32 PM
 */
public class Fresher_candidate extends Candidate {
	private int graduation_date;

	public int getGraduation_date() {
		return graduation_date;
	}

	public void setGraduation_date(int graduation_date) {
		this.graduation_date = graduation_date;
	}

	public String getGraduation_rank() {
		return graduation_rank;
	}

	public void setGraduation_rank(String graduation_rank) {
		this.graduation_rank = graduation_rank;
	}

	public String getEduCation() {
		return eduCation;
	}

	public void setEduCation(String eduCation) {
		this.eduCation = eduCation;
	}

	/**
	 * Descaption User Nov 28, 2017
	 */
	public Fresher_candidate() {
		// TODO Auto-generated constructor stub
	}

	private String graduation_rank;
	private String eduCation;

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
	public Fresher_candidate(String firstname, String lastname, int birthdate,
			String address, String phone, String email, int type,
			int graduation_date, String graduation_rank, String eduCation) {
		super(firstname, lastname, birthdate, address, phone, email, type);
		this.graduation_date = graduation_date;
		this.graduation_rank = graduation_rank;
		this.eduCation = eduCation;

	}

	public static void input() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Number Fresher Input: ");
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				Fresher_candidate fc = new Fresher_candidate();
				System.out.println("User " + (i + 1));
				System.out.println("First name: ");
				fc.setFirstName(sc.next());
				System.out.println("Last Name: ");
				fc.setLastName(sc.next());
				System.out.println("Birth date (YYYY-int): ");
				int date;
				date = sc.nextInt();
				while (date < 1900 || date > 2018) {
					System.out.println("Wrong type Date ! ");
					System.out.println("Birth date (YYYY-int): ");
					date = sc.nextInt();
				}
				fc.setBirthDate(date);
				System.out.println("Address: ");
				fc.setAddress(sc.next());
				System.out.println("Phone: ");
				String phone;
				phone = sc.next();
				while ((Integer.parseInt(phone) < 1000000)) {
					System.out.println("Phone: ");
					System.out.println("Min 7 number !");
					phone = sc.next();
				}
				fc.setPhone(phone);
				System.out.println("Email: ");
				String email;
				email = sc.next();
				while (!Validate.isEmail(email)) {
					System.out.println("Email: ");
					System.out.println("Wrong type Email !");
					email = sc.next();
				}
				fc.setEmail(email);
				fc.setCandidate_type(1);
				System.out.println("Graduation date(YYYY-int): ");
				int gradate;
				gradate = sc.nextInt();
				while (gradate < 1900 || gradate > 2018) {
					System.out.println("Wrong type Date ! ");
					System.out.println("Graduation date(YYYY-int): ");
					gradate = sc.nextInt();
				}
				fc.setGraduation_date(gradate);
				System.out
						.println("Graduation rank(Excellent or Good or Fair or Poor): ");
				String rank;
				rank = sc.next();
				while (!(rank.equals("Excellent") || rank.equals("Good")
						|| rank.equals("Fair") || rank.equals("Poor"))) {
					System.out.println("Excellent or Good or Fair or Poor !");
					System.out.println("Graduation rank(Excellent or Good or Fair or Poor): ");
					rank = sc.next();
				}
				fc.setGraduation_rank(rank);
				System.out.println("Education(String): ");
				fc.setEduCation(sc.next());

				if (FresherBus.insertFresher(fc)) {
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
		List<Fresher_candidate> list = FresherBus.getListFresher();
		for (Fresher_candidate user : list) {
			System.out.println("------------------------------------------------");
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Birth date: " + user.getBirthDate());
			System.out.println("Address: " + user.getAddress());
			System.out.println("Phone: " + user.getPhone());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Candidate type: Fresher");
			System.out.println("Graduation date: " + user.getGraduation_date());
			System.out.println("Graduation rank: " + user.getGraduation_rank());
			System.out.println("Education: " + user.getEduCation());
		}
	}

}
