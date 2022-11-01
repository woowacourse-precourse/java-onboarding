package onboarding.problem07.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem07.infra.exception.VisitorLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class VisitorsTest {

  @Test
  public void visitorsLengthExceptionText() throws Exception {
    List<String> names = new ArrayList<>();
    Assertions.assertThatThrownBy(() -> Visitors.of(names))
        .isInstanceOf(VisitorLengthException.class);
  }

}
