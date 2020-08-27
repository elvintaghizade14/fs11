package lesson01.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Params {

  public static Optional<Integer> toInt(String s) {
    try {
      return Optional.of(Integer.parseInt(s));
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  public static Optional<String> getStrParam(String par, HttpServletRequest rq) {
    return Optional.ofNullable(rq.getParameter(par));
  }

  public static Optional<Integer> getIntParam(String par, HttpServletRequest rq) {
    return getStrParam(par, rq).flatMap(Params::toInt);
  }
}
