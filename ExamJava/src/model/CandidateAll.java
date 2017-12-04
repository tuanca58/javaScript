/**
 * 
 */
package model;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:31:08 PM
 */
public class CandidateAll extends Candidate {
	private int expInYear;

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

	String proSkill;
	private int graduation_date;
	private String graduation_rank;
	private String eduCation;
	private String majors;
	private int semester;
	private String university_name;

	/**
	 * Descaption User Nov 28, 2017
	 */
	public CandidateAll() {
		super();
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
	public CandidateAll(String firstname, String lastname, int birthdate,
			String address, String phone, String email, int type, int expInYear,
			String proSkill, int graduation_date, String graduation_rank,
			String eduCation, String majors, int semester, String university_name) {
		super(firstname, lastname, birthdate, address, phone, email, type);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
		this.graduation_date = graduation_date;
		this.graduation_rank = graduation_rank;
		this.eduCation = eduCation;
		this.majors = majors;
		this.semester = semester;
		this.university_name = university_name;
	}

}
