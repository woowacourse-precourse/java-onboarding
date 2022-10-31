package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Problem1FuncTest {

  @Test
  public void validateExist() {
    List<Integer> pobi = Arrays.asList(null, 97);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateRange1() {
    List<Integer> pobi = List.of(0, 400);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateRange2() {
    List<Integer> pobi = List.of(1, 401);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateOddNumber() {
    List<Integer> pobi = List.of(2, 4);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateEvenNumber() {
    List<Integer> pobi = List.of(1, 3);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateContinues() {
    List<Integer> pobi = List.of(3, 2);
    boolean result = false;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void validateSuccess() {
    List<Integer> pobi = List.of(97, 98);
    boolean result = true;
    assertThat(Problem1.valid.validate(pobi)).isEqualTo(result);
  }

  @Test
  public void calculateMaxPoint1() {
    List<Integer> pobi = List.of(11, 12);
    int result = 3;
    assertThat(Problem1.calculation.getMaxPoint(pobi)).isEqualTo(result);
  }

  @Test
  public void calculateMaxPoint2() {
    List<Integer> pobi = List.of(97, 98);
    int result = 72;
    assertThat(Problem1.calculation.getMaxPoint(pobi)).isEqualTo(result);
  }

  @Test
  public void winPobi() {
    int result = 1;
    assertThat(Problem1.result.chooseWinner(10, 1)).isEqualTo(result);
  }

  @Test
  public void winCrong() {
    int result = 2;
    assertThat(Problem1.result.chooseWinner(1, 10)).isEqualTo(result);
  }

  @Test
  public void draw() {
    int result = 0;
    assertThat(Problem1.result.chooseWinner(10, 10)).isEqualTo(result);
  }

  @Test
  public void testCase1() {
    List<Integer> pobi = List.of(97, 98);
    List<Integer> crong = List.of(197, 198);
    int result = 0;
    assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    List<Integer> pobi = List.of(131, 132);
    List<Integer> crong = List.of(211, 212);
    int result = 1;
    assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
  }

  @Test
  public void testCase3() {
    List<Integer> pobi = List.of(99, 102);
    List<Integer> crong = List.of(211, 212);
    int result = -1;
    assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
  }

  @Test
  public void testCase4() {
    List<Integer> pobi = List.of(401, 402);
    List<Integer> crong = List.of(211, 212);
    int result = -1;
    assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
  }

}
