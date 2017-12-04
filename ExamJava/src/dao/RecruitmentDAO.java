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

import model.Recruitment;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+5:09:55 PM
 */
public class RecruitmentDAO {
	public static List<Recruitment> getRecruitment(String query) {
		List<Recruitment> userList = new ArrayList<Recruitment>();
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			try (PreparedStatement ps = conn.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Recruitment user = new Recruitment();
					user.setRecruitMent(rs.getInt(1));
					user.setTypeJob(rs.getString(2));
					user.setPacKage(rs.getString(3));
					user.setCandidate(rs.getInt(4));
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
