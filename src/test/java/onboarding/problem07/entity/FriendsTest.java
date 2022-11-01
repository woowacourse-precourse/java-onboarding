package onboarding.problem07.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import onboarding.problem07.infra.exception.ReduplicationFriendsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FriendsTest {

  @Test
  public void reduplicationFriendsException() throws Exception {
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "jun"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );

    Assertions.assertThatThrownBy(() -> Friends.of(friends))
        .isInstanceOf(ReduplicationFriendsException.class);
  }

}
