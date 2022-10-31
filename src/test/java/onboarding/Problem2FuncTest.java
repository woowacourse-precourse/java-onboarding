package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Problem2FuncTest {

  @Test
  public void decodeTest1() {
    String cryptogram = "browoanoommnaon";
    String result = "brown";
    assertThat(Problem2.code.decode(cryptogram)).isEqualTo(result);
  }

  @Test
  public void decodeTest2() {
    String cryptogram = "zyelleyz";
    String result = "";
    assertThat(Problem2.code.decode(cryptogram)).isEqualTo(result);
  }

  @Test
  public void decodeTest3() {
    String cryptogram = "abccbba";
    String result = "";
    assertThat(Problem2.code.decode(cryptogram)).isEqualTo(result);
  }

  @Test
  public void decodeTest4() {
    String cryptogram = "abaaaaaaab";
    String result = "a";
    assertThat(Problem2.code.decode(cryptogram)).isEqualTo(result);
  }

  @Test
  public void decodeTest5() {
    String cryptogram = "abcde";
    String result = "abcde";
    assertThat(Problem2.code.decode(cryptogram)).isEqualTo(result);
  }

  @Test
  public void testCase1() {
    String cryptogram = "browoanoommnaon";
    String result = "brown";
    assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    String cryptogram = "zyelleyz";
    String result = "";
    assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
  }

  @Test
  public void testCase3() {
    String cryptogram = "abccbba";
    String result = "";
    assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
  }

  @Test
  public void testCase4() {
    String cryptogram = "abaaaaaaab";
    String result = "a";
    assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
  }

  @Test
  public void testCase5() {
    String cryptogram = "abcde";
    String result = "abcde";
    assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
  }

}