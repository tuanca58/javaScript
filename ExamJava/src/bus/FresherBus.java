/**
 * 
 */
package bus;

import java.util.ArrayList;
import java.util.List;

import util.Const;
import model.Fresher_candidate;
import dao.FresherDAO;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+2:21:11 PM
 */
public class FresherBus {
  /**
   * Descaption User
   * 
   * @param fc
   * @return Nov 28, 2017
   */
  public static boolean insertFresher(Fresher_candidate fc) {
    new FresherDAO();
    return FresherDAO.insertCandidate(fc);
  }

  /**
   * Descaption User
   * 
   * @return Nov 28, 2017
   */
  public static List<Fresher_candidate> getListFresher() {
    List<Fresher_candidate> list = new ArrayList<Fresher_candidate>();
    FresherDAO ed = new FresherDAO();
    try {
      list = ed.getFresher(Const.SELECTFRESHER);
    } catch (Exception e) {
    }
    return list;
  }
}
