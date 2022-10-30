package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class Problem5FuncTest {

  @Test
  public void convertTest1() {
    int money = 50_237;
    List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
    assertThat(Problem5.converter.convert(money)).isEqualTo(result);
  }

  @Test
  public void convertTest2() {
    int money = 15_000;
    List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
    assertThat(Problem5.converter.convert(money)).isEqualTo(result);
  }

  @Test
  public void testCase1() {
    int money = 50_237;
    List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
    assertThat(Problem5.solution(money)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    int money = 15_000;
    List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
    assertThat(Problem5.solution(money)).isEqualTo(result);
  }
}