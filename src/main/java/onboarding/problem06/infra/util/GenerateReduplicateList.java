package onboarding.problem06.infra.util;

import java.util.ArrayList;
import java.util.List;

public class GenerateReduplicateList {

  public static List<String> generate(String nickname) {
    List<String> result = new ArrayList<>();
    char[] chars = nickname.toCharArray();

    for (int i = 0; i < chars.length - 1; i++) {
      result.add(Character.toString(chars[i]) + Character.toString(chars[i + 1]));
    }
    return result;
  }

}
