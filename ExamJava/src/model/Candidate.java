/**
 * 
 */
package model;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+1:40:30 PM
 */
public class Candidate {
	String firstName;

	/**
	 * Descaption User Nov 28, 2017
	 */
	public Candidate() {
	}
	/**Descaption
	 *User
	 * @param firstname
	 * @param lastname
	 * @param birthdate
	 * @param address
	 * @param phone
	 * @param email
	 * @param type
	 *Nov 28, 2017
	 */
	public Candidate(String firstname, String lastname, int birthdate,
			String address, String phone, String email, int type) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.birthDate = birthdate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.candidate_type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCandidate_type() {
		return candidate_type;
	}

	public void setCandidate_type(int candidate_type) {
		this.candidate_type = candidate_type;
	}

	private String lastName;
	private int birthDate;
	private String address;
	private String phone;
	private String email;
	private int candidate_type;

}
