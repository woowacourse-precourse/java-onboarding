package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NameStringClassForPro6 {

  private static String[] nameString;
  private static Set<String> nameSet;

  public NameStringClassForPro6(List<List<String>> forms) {
    ExceptionClassForPro6 exceptionClass = new ExceptionClassForPro6(forms);
    exceptionClass = null;
    nameString = new String[forms.size()];
    nameSet = new HashSet<>();
    fillNameString(forms);
  }

  private static void fillNameString(List<List<String>> forms) {
    for (int i = 0; i < forms.size(); i++) {
      List<String> partOfForm = forms.get(i);
      nameString[i] = partOfForm.get(1);
    }
  }

  public Set<String> mainFunc() {
    for (int i = 0; i < nameString.length; i++) {
      NameForPro6 nameI = new NameForPro6(nameString[i]);
      for (int j = i + 1; j < nameString.length; j++) {
        NameForPro6 nameJ = new NameForPro6(nameString[j]);
        prepareAnsSet(nameI, nameJ);
      }
    }
    return nameSet;
  }

  private static void prepareAnsSet(NameForPro6 nameI, NameForPro6 nameJ) {
    checkDPAndFill(nameI, nameJ, new int[nameI.nameSize() + 1][nameJ.nameSize() + 1]);
  }

  private static void checkDPAndFill(NameForPro6 nameI, NameForPro6 nameJ, int[][] dp) {
    int max = 0;
    for (int i = 1; i <= nameI.nameSize(); i++) {
      for (int j = 1; j <= nameJ.nameSize(); j++) {
        if (nameI.nameChar(i - 1) == nameJ.nameChar(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          max = Math.max(max, dp[i][j]);
        }
        if (max > 1) {
          nameSet.add(nameI.toString());
          nameSet.add(nameJ.toString());
        }
      }
    }
  }

  public int stringNameLen() {
    return nameString.length;
  }

  public String oneNameString(int index) {
    return nameString[index];
  }
}

class NameForPro6 {

  private final String name;

  public NameForPro6(String name) {
    this.name = name;
  }

  public int nameSize() {
    return name.length();
  }

  public char nameChar(int index) {
    return name.charAt(index);
  }

  public String toString() {
    return name;
  }
}

class ExceptionClassForPro6 {

  private static final int MINIMUM_MEMBER = 1;
  private static final int MAXIMUM_MEMBER = 10000;
  private static final int EMAIL_LENGTH_MIN = 11;
  private static final int EMAIL_LENGTH_MAX = 20;
  private static final int NICK_LENGTH_MIN = 1;
  private static final int NICK_LENGTH_MAX = 20;

  public ExceptionClassForPro6(List<List<String>> forms) {
    validateArguments(forms);
  }

  private void validateArguments(List<List<String>> forms) {
    validateTotalMember(forms);
    for (List<String> userProfile : forms) {
      validateEmail(userProfile.get(0));
      validateEmailLength(userProfile.get(0));
      validateNickLength(userProfile.get(1));
      validateNickKor(userProfile.get(1));
    }
  }

  private void validateTotalMember(List<List<String>> forms) {
    if (forms.size() < MINIMUM_MEMBER || MAXIMUM_MEMBER < forms.size()) {
      throw new IllegalArgumentException(
          "총 인원 수는 " + MINIMUM_MEMBER + "이상 " + MAXIMUM_MEMBER + "이하의 정수여야 합니다.");
    }
  }

  private static void validateEmail(String email) {
    Pattern p = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
    Matcher m = p.matcher(email);
    if (!m.matches()) {
      throw new IllegalArgumentException("이메일 형식이 올바르지 않습니다.");
    }
    if (!email.contains("@email.com")) {
      throw new IllegalArgumentException("이메일의 도메인은 반드시 @email.com이어야 합니다.");
    }
  }

  private static void validateEmailLength(String email) {
    if (email.length() < EMAIL_LENGTH_MIN || EMAIL_LENGTH_MAX <= email.length()) {
      throw new IllegalArgumentException(
          "이메일의 길이는 " + EMAIL_LENGTH_MIN + "이상 " + EMAIL_LENGTH_MAX + "미만의 정수여야 합니다.");
    }
  }

  private static void validateNickLength(String nickname) {
    if (nickname.length() < NICK_LENGTH_MIN || NICK_LENGTH_MAX <= nickname.length()) {
      throw new IllegalArgumentException(
          "닉네임의 길이는 " + NICK_LENGTH_MIN + "이상 " + NICK_LENGTH_MAX + " 미만의 정수여야 합니다.");
    }
  }

  private static void validateNickKor(String nickname) {
    if (!nickname.matches("^[가-힣]*$")) {
      throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
    }
  }
}

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    NameStringClassForPro6 nameClass = new NameStringClassForPro6(forms);
    return sortAnsSet(nameClass.mainFunc(), nameClass, forms);
  }

  public static List<String> sortAnsSet(Set<String> ansSet, NameStringClassForPro6 nameClass,
      List<List<String>> forms) {
    List<String> ansList = new ArrayList<>();
    ansSet.forEach((element) -> {
      for (int i = 0; i < nameClass.stringNameLen(); i++) {
        if (Objects.equals(element, nameClass.oneNameString(i))) {
          List<String> tmpList = forms.get(i);
          ansList.add(tmpList.get(0));
        }
      }
    });
    ansList.sort(String::compareTo);
    return ansList;
  }
}
