/**
 * 
 */
package view;

import java.util.List;
import java.util.Scanner;

import model.CandidateAll;
import model.Recruitment;
import bus.CandidateAllBus;
import bus.RecruitmentBus;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:17:59 PM
 */
public class Recruiment_Main {
	static List<Recruitment> recu;
	static List<CandidateAll> cdall;
	static int increment = 0;
	
	/**Descaption Create menu UI.
	 *User
	 *Nov 29, 2017
	 */
	static void menu() {
		System.out.println("\n1.Find Recruitment\n2.Exit");
	}

	/**
	 * Descaption input method. 
	 * User Nov 28, 2017
	 */
	static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Packget :");
		String packget = sc.next();
		System.out.println("Email Candidate:");
		String email = sc.next();
		if (check(email, packget)) {
			System.out.println("Submitted this candidate successfully");
			System.out.println("Candidate: "
					+ RecruitmentBus.getCandidateNumber(packget));
		} else {
			System.out.println("This candidate not matching !");
			System.out.println("Candidate: "
					+ RecruitmentBus.getCandidateNumber(packget));
		}sc.close();
	}

	/**
	 * Descaption check Candidate.
	 * 
	 * @param email
	 * @param id
	 * @return boolean Nov 28, 2017
	 */
	static boolean check(String email, String packget) {
		String packag = "";
		int candidate = 5;
		String type = "";
		for (int i = 0; i < recu.size(); i++) {
			if (recu.get(i).getPacKage().equals(packget)) {
				packag = recu.get(i).getPacKage();
			}
		}
		for (int i = 0; i < cdall.size(); i++) {
			if (cdall.get(i).getEmail().equals(email)) {
				candidate = cdall.get(i).getCandidate_type();
			}
		}
		// if candidate set type =A or B or C or D.
		switch (candidate) {
		case 0:
			type = "A";
			break;
		case 1:
			type = "B";
			break;
		case 2:
			type = "C";
			break;
		default:
			type = "D";
			break;
		}

		if (packag.equals(type)) {
			increment++;
			CandidateAllBus.insert(increment, packget);
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// get list Recruitment.
		recu = RecruitmentBus.getList();
		// get list Candidate
		cdall = CandidateAllBus.getAll();
		int num = 0;
		Scanner sc = new Scanner(System.in);
		menu();
		while (true) {
			try {
				num = Integer.parseInt(sc.next());
				switch (num) {
				case 1:
					input();
					menu();
					break;
				case 2:
					return;
				default:
					System.out.print("Error!");
					menu();
					break;
				}
			} catch (Exception e) {
				System.out.print("Error!");
				menu();
			}
			sc.close();
		}
	}
}
