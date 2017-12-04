/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Const;
import model.*;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+2:01:24 PM
 */
public class ExperienceDAO {
	/**
	 * Descaption insert new Experience
	 * User.
	 * 
	 * @param ec
	 *          .
	 * @return boolean. Nov 28, 2017.
	 */
	public static boolean insertExperience(Experience_candidate ec) {
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String query = Const.INSERTEXPERIENCE;
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setString(1, ec.getFirstName());
				ps.setString(2, ec.getLastName());
				ps.setInt(3, ec.getBirthDate());
				ps.setString(4, ec.getAddress());
				ps.setString(5, ec.getPhone());
				ps.setString(6, ec.getEmail());
				ps.setInt(7, ec.getCandidate_type());
				ps.setInt(8, ec.getExpInYear());
				ps.setString(9, ec.getProSkill());
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

	/**Descaption get list Experience_candidate
	 *User
	 * @param query
	 * @return list Experience_candidate
	 *Nov 28, 2017
	 */
	public static List<Experience_candidate> getExperience(String query) {
		List<Experience_candidate> userList = new ArrayList<Experience_candidate>();
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Experience_candidate user = new Experience_candidate();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setBirthDate(rs.getInt(3));
					user.setAddress(rs.getString(4));
					user.setPhone(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setCandidate_type(rs.getInt(7));
					user.setExpInYear(rs.getInt(8));
					user.setProSkill(rs.getString(9));
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
