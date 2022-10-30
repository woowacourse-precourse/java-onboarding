package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Problem4FuncTest {

  @Test
  public void numberConvertTest() {
    String word = "1";
    String result = "1";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void blankConvertTest() {
    String word = " ";
    String result = " ";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void koreanConvertTest() {
    String word = "안녕하세요";
    String result = "안녕하세요";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void lowerCaseConvertTest() {
    String word = "abcz";
    String result = "zyxa";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void upperCaseConvertTest() {
    String word = "ZYXA";
    String result = "ABCZ";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void symbolConvertTest() {
    String word = "!@#$";
    String result = "!@#$";
    assertThat(Problem4.converter.convert(word)).isEqualTo(result);
  }

  @Test
  public void testCase1() {
    String word = "I love you";
    String result = "R olev blf";
    assertThat(Problem4.solution(word)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    String word = "안녕하세요 Happy 123!!";
    String result = "안녕하세요 Szkkb 123!!";
    assertThat(Problem4.solution(word)).isEqualTo(result);
  }

}