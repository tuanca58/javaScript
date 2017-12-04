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
public class InterDAO {
	/**
	 * Descaption User.
	 * 
	 * @param ec
	 *          .
	 * @return boolean. Nov 28, 2017.
	 */
	public static boolean insertCandidate(Inter_candidate ic) {
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String query = Const.INSERTINTER;
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ps.setString(1, ic.getFirstName());
				ps.setString(2, ic.getLastName());
				ps.setInt(3, ic.getBirthDate());
				ps.setString(4, ic.getAddress());
				ps.setString(5, ic.getPhone());
				ps.setString(6, ic.getEmail());
				ps.setInt(7, ic.getCandidate_type());
				ps.setString(8, ic.getMajors());
				ps.setInt(9, ic.getSemester());
				ps.setString(10, ic.getUniversity_name());
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

	public static List<Inter_candidate> getInter(String query) {
		List<Inter_candidate> userList = new ArrayList<Inter_candidate>();
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Inter_candidate user = new Inter_candidate();
					user.setFirstName(rs.getString(1));
					user.setLastName(rs.getString(2));
					user.setBirthDate(rs.getInt(3));
					user.setAddress(rs.getString(4));
					user.setPhone(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setCandidate_type(rs.getInt(7));
					user.setMajors(rs.getString(8));
					user.setSemester(rs.getInt(9));
					user.setUniversity_name(rs.getString(10));
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
