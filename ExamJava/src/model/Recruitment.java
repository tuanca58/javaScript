/**
 * 
 */
package model;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:06:49 PM
 */
public class Recruitment {
	/**Descaption contructor
	 *User
	 *Nov 28, 2017
	 */
	public Recruitment() {
	}
	/**Descaption contructor with param
	 *User
	 * @param recruitMent
	 * @param typeJob
	 * @param pacKage
	 * @param candidate
	 *Nov 28, 2017
	 */
	public Recruitment(int recruitMent, String typeJob, String pacKage,
			int candidate) {
		super();
		this.recruitMent = recruitMent;
		this.typeJob = typeJob;
		this.pacKage = pacKage;
		Candidate = candidate;
	}
	private int recruitMent;
	public int getRecruitMent() {
		return recruitMent;
	}
	public void setRecruitMent(int recruitMent) {
		this.recruitMent = recruitMent;
	}
	public String getTypeJob() {
		return typeJob;
	}
	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
	}
	public String getPacKage() {
		return pacKage;
	}
	public void setPacKage(String pacKage) {
		this.pacKage = pacKage;
	}
	public int getCandidate() {
		return Candidate;
	}
	public void setCandidate(int candidate) {
		Candidate = candidate;
	}
	private String typeJob;
	private String pacKage;
	private int Candidate;

}
