package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ValidatorPro6 {

  public final static int EMAIL = 0;
  public final static int NICKNAME = 1;
  public final static int MIN_CREW_NUM = 1;
  public final static int MAX_CREW_NUM = 10_000;
  public final static int MIN_EMAIL_LEN = 11;
  public final static int MAX_EMAIL_LEN = 20;
  public final static int MIN_NICKNAME_LEN = 1;
  public final static int MAX_NICKNAME_LEN = 20;

  public ValidatorPro6(List<List<String>> forms) {
    validateCrewNum(forms);
    validateEmail(forms);
    validateNickName(forms);
  }

  public void validateCrewNum(List<List<String>> forms) {
    if (forms.size() < MIN_CREW_NUM || forms.size() > MAX_CREW_NUM) {
      throw new IllegalArgumentException(
          "Crew is more than" + MIN_CREW_NUM + " and less than " + MAX_CREW_NUM + " people.");
    }
  }

  public boolean isEmail(String str) {
    return Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", str);
  }

  public void validateEmail(List<List<String>> forms) {
    for (List<String> crewInfo : forms) {
      if (!isEmail(crewInfo.get(EMAIL)) ||
          !crewInfo.get(EMAIL).contains("email.com") ||
          (crewInfo.get(EMAIL).length() < MIN_EMAIL_LEN) ||
          (crewInfo.get(EMAIL).length() >= MAX_EMAIL_LEN)) {
        throw new IllegalArgumentException(
            "The e-mail conforms to the e-mail format, and the total length is more than"
                + MIN_EMAIL_LEN + " characters and less than" + MAX_EMAIL_LEN + " characters.");
      }
    }
  }

  public boolean isKorean(String str) {
    return Pattern.matches("[가-힣]*$", str);
  }

  public void validateNickName(List<List<String>> forms) {
    for (List<String> crewInfo : forms) {
      if (!isKorean(crewInfo.get(NICKNAME)) ||
          crewInfo.get(NICKNAME).length() < MIN_NICKNAME_LEN ||
          crewInfo.get(NICKNAME).length() >= MAX_NICKNAME_LEN) {
        throw new IllegalArgumentException(
            "Nicknames can only be in Korean, and the total length must be between "
                + MIN_NICKNAME_LEN + "and" + MAX_NICKNAME_LEN + "characters.");
      }
    }
  }
}

class FindDuplicatePro6 {

  public final static int EMAIL = 0;
  public final static int NICKNAME = 1;

  private final Set<String> emails;

  public FindDuplicatePro6(List<List<String>> forms) {
    this.emails = findDuplicateWord(forms);
  }

  public static Set<String> findDuplicateWord(List<List<String>> forms) {
    Set<String> seen = new HashSet<>();
    Set<String> emails = new HashSet<>();
    for (int crewIdx = 0; crewIdx < forms.size(); crewIdx++) {
      for (int i = 0; i < forms.get(crewIdx).get(NICKNAME).length() - 1; i++) {
        String compareStr = forms.get(crewIdx).get(NICKNAME).substring(i, i + 2);
        seen.add(compareStr);
      }
      boolean noDuplicate = false;
      for (int j = crewIdx + 1; j < forms.size(); j++) {
        for (String str : seen) {
          if (forms.get(j).get(NICKNAME).contains(str)) {
            emails.add(forms.get(j).get(EMAIL));
            noDuplicate = true;
          }
        }
      }
      seen.clear();
      if (noDuplicate) {
        emails.add(forms.get(crewIdx).get(EMAIL));
      }
    }
    return emails;
  }

  public Set<String> getEmails() {
    return emails;
  }
}

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    ValidatorPro6 validator = new ValidatorPro6(forms);
    return new ArrayList<>(new FindDuplicatePro6(forms).getEmails())
        .stream()
        .sorted()
        .collect(Collectors.toList());
  }
}