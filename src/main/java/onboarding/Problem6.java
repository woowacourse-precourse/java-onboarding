package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
      boolean flag = false;
      for (int j = crewIdx + 1; j < forms.size(); j++) {
        for (String str : seen) {
          if (forms.get(j).get(NICKNAME).contains(str)) {
            emails.add(forms.get(j).get(EMAIL));
            flag = true;
          }
        }
      }
      seen.clear();
      if (flag) {
        emails.add(forms.get(crewIdx).get(EMAIL));
      }
    }
    return emails;
  }

  public Set<String> getEmails() {
    return emails;
  }
}

class ValidatorPro6 {

  public final static int EMAIL = 0;
  public final static int NICKNAME = 1;
  public final static int MIN_CREW_NUM = 1;
  public final static int MAX_CREW_NUM = 10_000;
  public final static int MIN_EMAIL_LEN = 11;
  public final static int MAX_EMAIL_LEN = 19;
  public final static int MIN_NICKNAME_LEN = 1;
  public final static int MAX_NICKNAME_LEN = 20;

  public ValidatorPro6(List<List<String>> forms) {
    validateCrewNum(forms);
    validateEmail(forms);
    validateNickName(forms);
  }

  public void validateCrewNum(List<List<String>> forms) {
    if (forms.size() < MIN_CREW_NUM || forms.size() > MAX_CREW_NUM) {
      throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하이다");
    }
  }

  public void validateEmail(List<List<String>> forms) {
    for (List<String> crewInfo : forms) {
      if (!crewInfo.get(EMAIL).contains("email.com") ||
          crewInfo.get(EMAIL).length() < MIN_EMAIL_LEN
          || crewInfo.get(EMAIL).length() >= MAX_EMAIL_LEN) {
        throw new IllegalArgumentException("이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다");
      }
    }
  }

  public boolean isKorean(String str) {
    return Pattern.matches("[가-힣]*$", str);
  }

  public void validateNickName(List<List<String>> forms) {
    for (List<String> crewInfo : forms) {
      if (!isKorean(crewInfo.get(NICKNAME)) || crewInfo.get(NICKNAME).length() < MIN_NICKNAME_LEN
          || crewInfo.get(NICKNAME).length() > MAX_NICKNAME_LEN) {
        throw new IllegalArgumentException("닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.");
      }
    }
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