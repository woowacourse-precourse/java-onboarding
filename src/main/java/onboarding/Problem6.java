package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    List<String> answer = new ArrayList<String>();
    for (int i = 0; i < forms.size(); i++) {
      List<String> crew = forms.get(i);
      if (checkDuplicates(forms, crew.get(1), i)) {
        answer.add(crew.get(0));
      }
    }
    Collections.sort(answer);
    return answer;
  }

  private static boolean checkDuplicates(List<List<String>> forms, String name, int index) {
    if (name.length() == 1) {
      return false;
    }
    for (int i = 0; i < name.length() - 1; i++) {
      char[] twoLetters = new char[2];
      name.getChars(i, i + 2, twoLetters, 0);
      if (findDuplicates(forms, new String(twoLetters), index)) {
        return true;
      }
    }
    return false;
  }

  private static boolean findDuplicates(List<List<String>> forms, String twoLetters, int index) {
    for (int i = 0; i < forms.size(); i++) {
      if (i == index) {
        continue;
      }
      List<String> crew = forms.get(i);
      String crewName = crew.get(1);
      if (crewName.contains(twoLetters)) {
        return true;
      }
    }
    return false;
  }
}
