package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    List<String> answer = List.of("answer");
    List<String> duplicateCrewEmails = getDuplicateCrewEmails(forms);

    return duplicateCrewEmails;
  }

  public static List<String> getDuplicateCrewEmails(List<List<String>> forms) {
    List<String> duplicateNameCrews = new ArrayList<>();

    for (int i = 0; i < forms.size(); i++) {
      List<String> target = forms.get(i);
      String name = target.get(1);
      if(findOthersByName(name, forms, i)){
        duplicateNameCrews.add(target.get(0));
      }
    }
    return duplicateNameCrews;
  }

  public static boolean findOthersByName(String name, List<List<String>> forms, int index) {
    for (int j = 0; j < name.length() - 1; j++) {
      for (int k = j + 2; k <= name.length(); k++) {
        String checkName = name.substring(j, k);
        if (isDuplicateOthers(checkName, forms, index)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isDuplicateOthers(String name, List<List<String>> forms, int index) {
    for (int i = 0; i < forms.size(); i++) {
      if (i == index) {
        continue;
      }
      List<String> compareCrew = forms.get(i);
      String compareCrewName = compareCrew.get(1);
      if (compareCrewName.contains(name)) {
        return true;
      }
    }
    return false;
  }

}
