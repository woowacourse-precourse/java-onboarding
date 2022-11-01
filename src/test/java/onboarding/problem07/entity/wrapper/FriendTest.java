package onboarding.problem07.entity.wrapper;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import onboarding.problem07.infra.exception.FriendListEmptyException;
import onboarding.problem07.infra.exception.FriendSizeWrongException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FriendTest {


  @Test
  public void friendSizeExceptionTest() throws Exception {
    List<String> friendName = List.of("abc", "def", "ghi");
    assertThatThrownBy(() -> Friend.of(friendName)).isInstanceOf(FriendSizeWrongException.class);

  }

  @Test
  public void friendEmptyListExceptionTest() throws Exception {
    List<String> friendName = List.of("abc", "");
    assertThatThrownBy(() -> Friend.of(friendName)).isInstanceOf(FriendListEmptyException.class);
  }

}
