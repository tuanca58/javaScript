/**
 * 
 */
package bus;

import java.util.ArrayList;
import java.util.List;

import util.Const;
import model.Inter_candidate;
import dao.InterDAO;

/**
 * Descaption
 * 
 * @author User Create time Nov 28, 2017+2:21:17 PM
 */
public class InterBus {
  /**
   * Descaption User
   * 
   * @param ic
   * @return Nov 28, 2017
   */
  public static boolean insertInter(Inter_candidate ic) {
    new InterDAO();
    return InterDAO.insertCandidate(ic);
  }

  /**
   * Descaption User
   * 
   * @return Nov 28, 2017
   */
  public static List<Inter_candidate> getListInter() {
    List<Inter_candidate> list = new ArrayList<Inter_candidate>();
    InterDAO id = new InterDAO();
    try {
      list = id.getInter(Const.SELECTTER);
    } catch (Exception e) {
    }
    return list;
  }
}
