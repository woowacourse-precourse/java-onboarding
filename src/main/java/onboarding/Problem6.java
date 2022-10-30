package onboarding;

import onboarding.problem6.NicknameValidation;
import onboarding.problem6.WoowaTechCourse;

import java.util.*;

public class Problem6 {
  public static List<String> solution(List<List<String>> forms) {
    NicknameValidation nicknameValidation = new NicknameValidation();
    WoowaTechCourse woowaTechCourse = new WoowaTechCourse();
    woowaTechCourse.addCrewFromForms(forms);
    List<String> duplicateNicknames = nicknameValidation.validate(woowaTechCourse.getCrewsNickname());
    return woowaTechCourse.getCrewEmailByNickname(duplicateNicknames);
  }
}
