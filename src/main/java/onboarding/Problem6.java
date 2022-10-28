package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    List<List<String>> parsingForms = new ArrayList<>();
    for (List<String> form : forms) {
      parsingForms.add(Converter.convert(form));
    }
    return new ArrayList<String>();
  }

  static class Converter {

    public static List<String> convert(List<String> form) {
      List<String> result = new ArrayList<>();
      result.add(form.get(0));

      String nickname = form.get(1);
      for (int i = 0; i < nickname.length() - 1; i++) {
        result.add(nickname.substring(i, i + 2));
      }
      return result;
    }
  }
}
