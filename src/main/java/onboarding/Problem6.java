package onboarding;

import onboarding.problem6.Validator;

import java.util.*;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    Validator.validate(forms);
    return new ArrayList<>();
  }

  private static Set<String> subStringNicknameByTwo(String nickname) {
    Set<String> subStringByTwoNicknameSet = new HashSet<>();
    int nicknameLength = nickname.length() - 1;
    for (int i = 0; i < nicknameLength; i++) {
      subStringByTwoNicknameSet.add(nickname.substring(i, i + 2));
    }
    return subStringByTwoNicknameSet;
  }
}
