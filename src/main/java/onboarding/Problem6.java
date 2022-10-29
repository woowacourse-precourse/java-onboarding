package onboarding;

import java.util.*;

public class Problem6 {

  public static List<String> findDuplicateWord(List<List<String>> forms) {
    List<String> seen = new ArrayList<>();
    List<String> email = new ArrayList<>();
    int n = -1;
    for (int i = 0; i < forms.size(); i++) {
      for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
        String compareStr = forms.get(i).get(1).substring(j, j + 2);
        if (!seen.contains(compareStr)) {
          seen.add(compareStr);
          n++;
        } else {
          continue;
        }
        boolean flag = false;
        for (int k = i + 1; k < forms.size() - i; k++) {
          if (forms.get(k).get(1).contains(seen.get(n))) {
            email.add(forms.get(k).get(0));
            if (flag == false) {
              email.add(forms.get(i).get(0));
              flag = true;
            }
          }
        }
      }
    }
    return email;
  }

  public static List<String> solution(List<List<String>> forms) {
    return findDuplicateWord(forms);
  }
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(solution(forms));
    }
}

//  public static List<String> findDuplicateWord(List<List<String>> forms) {
//    List<String> seen = new ArrayList<>();
//    List<String> email = new ArrayList<>();
//    int n = -1;
//    for (int i = 0; i < forms.size(); i++) {
//      for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
//        String compareStr = forms.get(i).get(1).substring(j, j + 2);
//        if (!seen.contains(compareStr)) {
//          seen.add(compareStr);
//          n++;
//        } else {
//          continue;
//        }
//        boolean flag = false;
//        for (int k = i + 1; k < forms.size() - i; k++) {
//          if (forms.get(k).get(1).contains(seen.get(n))) {
//            email.add(forms.get(k).get(0));
//            if (flag == false) {
//              email.add(forms.get(i).get(0));
//              flag = true;
//            }
//          }
//        }
//      }
//    }
//    return email;
//  }

