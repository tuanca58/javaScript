/**
 * 
 */
package bus;

import java.util.ArrayList;
import java.util.List;

import util.Const;
import model.Experience_candidate;
import dao.ExperienceDAO;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+2:00:34 PM
 */
public class ExperienceBus {
  /**
   * Descaption User
   * 
   * @param ec
   * @return Nov 28, 2017
   */
  public static boolean insertExperience(Experience_candidate ec) {
    new ExperienceDAO();
    return ExperienceDAO.insertExperience(ec);
  }

  /**
   * Descaption User
   * 
   * @return Nov 28, 2017
   */
  public static List<Experience_candidate> getListExperience() {
    List<Experience_candidate> list = new ArrayList<Experience_candidate>();
    ExperienceDAO ed = new ExperienceDAO();
    try {
      list = ed.getExperience(Const.SELECTEX);
    } catch (Exception e) {
    }
    return list;
  }
}
