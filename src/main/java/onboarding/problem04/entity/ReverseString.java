package onboarding.problem04.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import onboarding.problem04.infra.exception.StringLengthOutOfRange;

public class ReverseString {

  private List<Character> letterSet = new ArrayList<>();
  private String result = "";

  private ReverseString(String givenString) {
    if (givenString.length() < 1 && givenString.length() > 1000) {
      throw new StringLengthOutOfRange();
    }
    this.result = result;
  }

  public static ReverseString from(String str) {
    return new ReverseString(str);
  }

  private String processing(String str) {
    letterSet = str.chars().mapToObj(index -> (char) index)
        .collect(Collectors.toList());
    for (Character character : letterSet) {
      if (character == ' ') {
        continue;
      } else if ((int) character >= 65 && (int) character <= 90) {
        // 소문자 처리
      } else if ((int) character >= 97 && (int) character <= 121){
        // 대문자 처리

      }
    }
  }
}
