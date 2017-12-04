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
public class FresherDAO {
	/**
	 * Descaption User.
	 * 
	 * @param ec
	 *          .
	 * @return boolean. Nov 28, 2017.
	 */
	public static boolean insertCandidate(Fresher_candidate fc) {
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String query = Const.INSERTCANDIDATE;
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setString(1, fc.getFirstName());
				ps.setString(2, fc.getLastName());
				ps.setInt(3, fc.getBirthDate());
				ps.setString(4, fc.getAddress());
				ps.setString(5, fc.getPhone());
				ps.setString(6, fc.getEmail());
				ps.setInt(7, fc.getCandidate_type());
				ps.setInt(8, fc.getGraduation_date());
				ps.setString(9, fc.getGraduation_rank());
				ps.setString(10, fc.getEduCation());
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

	public static List<Fresher_candidate> getFresher(String query) {
		List<Fresher_candidate> userList = new ArrayList<Fresher_candidate>();
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Fresher_candidate user = new Fresher_candidate();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setBirthDate(rs.getInt(3));
					user.setAddress(rs.getString(4));
					user.setPhone(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setCandidate_type(rs.getInt(7));
					user.setGraduation_date(rs.getInt(8));
					user.setGraduation_rank(rs.getString(9));
					user.setEduCation(rs.getString(10));
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
