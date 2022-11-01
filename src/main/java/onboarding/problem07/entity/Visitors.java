package onboarding.problem07.entity;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem07.entity.wrapper.Name;
import onboarding.problem07.infra.exception.VisitorLengthException;

public class Visitors {

  private List<Name> visitor;

  private Visitors(List<String> names) {
    if (names.isEmpty() || names.size() > 10000) {
      throw new VisitorLengthException();
    }
    visitor = new ArrayList<>();

  }

  public static Visitors of(List<String> names) {
    return new Visitors(names);
  }
}
