package view;

import java.util.Scanner;

import util.Const;
import model.Experience_candidate;
import model.Fresher_candidate;
import model.Inter_candidate;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+9:30:12 AM
 */
public class Candidate_Main {
	static void menu() {
		System.out.println(Const.MENU);
	}

	public static void main(String[] args) {
		Experience_candidate ec = new Experience_candidate();
		Fresher_candidate fc = new Fresher_candidate();
		Inter_candidate ic = new Inter_candidate();
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		menu();
		while (true) {
			try {
				num = Integer.parseInt(scanner.next());
				switch (num) {
				case 1:
					ec.input();
					menu();
					break;
				case 2:
					fc.input();
					menu();
					break;
				case 3:
					ic.input();
					menu();
					break;
				case 4:
					ec.getList();
					fc.getList();
					ic.getList();
					menu();
					break;
				case 5:
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
			scanner.close();
		}
	}

}
