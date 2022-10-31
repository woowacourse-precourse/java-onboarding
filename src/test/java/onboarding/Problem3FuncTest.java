package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Problem3FuncTest {

  @Test
  public void gameTest1() {
    int number = 13;
    int result = 4;
    assertThat(Problem3.game.start(number)).isEqualTo(result);
  }

  @Test
  public void gameTest2() {
    int number = 33;
    int result = 14;
    assertThat(Problem3.game.start(number)).isEqualTo(result);
  }

  @Test
  public void gameTest3() {
    int number = 324;
    int result = 212;
    assertThat(Problem3.game.start(number)).isEqualTo(result);
  }

  @Test
  public void testCase1() {
    int number = 13;
    int result = 4;
    assertThat(Problem3.solution(number)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    int number = 33;
    int result = 14;
    assertThat(Problem3.solution(number)).isEqualTo(result);
  }

  @Test
  public void testCase3() {
    int number = 324;
    int result = 212;
    assertThat(Problem3.solution(number)).isEqualTo(result);
  }

  @Test
  public void testCase4() {
    int number = 2;
    int result = 0;
    assertThat(Problem3.solution(number)).isEqualTo(result);
  }

}