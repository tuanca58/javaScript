/**
 * 
 */
package bus;

import java.util.ArrayList;
import java.util.List;

import model.Recruitment;
import dao.CandidateAllDAO;
import dao.RecruitmentDAO;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:13:55 PM
 */
public class RecruitmentBus {

	/**
	 * Descaption get list Recruitment User
	 * 
	 * @return list Nov 28, 2017
	 */
	public static List<Recruitment> getList() {
		List<Recruitment> list = new ArrayList<Recruitment>();
		try {
			list = RecruitmentDAO
					.getRecruitment("Select * from [dbo].[Recruitment] ");
		} catch (Exception e) {
		}
		return list;
	}

	public static int getCandidateNumber(String packget) {
		int i = 0;
		try {
			i = CandidateAllDAO.getCandidateNumber(
					"Select SUM([Candidate]) FROM [Candidate].[dbo].[Recruitment] WHERE Package=? GROUP BY [Candidate] ", packget);
		} catch (Exception e) {
		}
		return i;
	}

}
