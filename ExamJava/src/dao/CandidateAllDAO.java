package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Const;
import model.CandidateAll;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:37:19 PM
 */
public class CandidateAllDAO {
	/**
	 * Descaption Inseret Candidate if found Candidate. User
	 * 
	 * @param i
	 * @param Package
	 * @return Nov 29, 2017
	 */
	public static boolean insertIncrement(int i, String Package) {
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String query = Const.UPDATECANDIDATE;
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setInt(1, i);
				ps.setString(2, Package);
				return ps.executeUpdate() > 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Database empty !");
			}
		}
	}

	/**Descaption get Candidate number match.
	 * User
	 * @param query
	 * @param Package
	 * @return
	 *Nov 29, 2017
	 */
	public static int getCandidateNumber(String query, String Package) {
		Connection conn = null;
		int i=0;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setString(1, Package);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i = (rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return i;
	}

	/**
	 * Descaption get list all Candidate with all coloumns. User
	 * 
	 * @param query
	 * @return Nov 29, 2017
	 */
	public static List<CandidateAll> getAll(String query) {
		List<CandidateAll> userList = new ArrayList<CandidateAll>();
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					CandidateAll user = new CandidateAll();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setBirthDate(rs.getInt(3));
					user.setAddress(rs.getString(4));
					user.setPhone(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setCandidate_type(rs.getInt(7));
					user.setExpInYear(rs.getInt(8));
					user.setProSkill(rs.getString(9));
					user.setGraduation_date(rs.getInt(10));
					user.setGraduation_rank(rs.getString(11));
					user.setEduCation(rs.getString(12));
					user.setMajors(rs.getString(13));
					user.setSemester(rs.getInt(14));
					user.setUniversity_name(rs.getString(15));
					userList.add(user);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return userList;
	}

}
