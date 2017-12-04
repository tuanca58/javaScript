/**
 * 
 */
package util;

/**
 * Descaption
 * 
 * @author User Create time Nov 29, 2017+8:05:34 AM
 */
public class Const {
	public static final String INSERTEXPERIENCE = "INSERT INTO [dbo].[Candidate]([FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[ExpInYear],[ProSkill]) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERTCANDIDATE = "INSERT INTO [dbo].[Candidate]( [FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[Graduation_date],[Graduation_rank],[Education]) VALUES (?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERTINTER = "INSERT INTO [dbo].[Candidate]( [FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[Majors],[Semester],[University_name]) VALUES (?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECTTER = "Select [FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[Majors],[Semester],[University_name] from [dbo].[Candidate] WHERE [Candidate_type]=2";
	public static final String SELECTFRESHER = "Select [FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[Graduation_date],[Graduation_rank],[Education] from [dbo].[Candidate] WHERE [Candidate_type]=1";
	public static final String SELECTEX = "Select [FirstName],[LastName],[BirthDate],[Adress],[Phone],[Email],[Candidate_type],[ExpInYear],[ProSkill] from [dbo].[Candidate] WHERE [Candidate_type]=0";
	public static final String MENU = "\n1.Input Experience candidate\n2.Input Fresher candidate\n3.Input Intern cadidate\n4.Exprot all cadidate\n5.Quit";
	public static final String UPDATECANDIDATE = "UPDATE  [dbo].[Recruitment] SET [Candidate]=? WHERE [Package]=?";

}
