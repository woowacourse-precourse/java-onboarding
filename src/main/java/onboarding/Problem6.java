package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    ValidatorPro6 validator = new ValidatorPro6(forms);
    return new ArrayList<>(new FindDuplicatePro6(forms).getEmails())
        .stream()
        .sorted()
        .collect(Collectors.toList());
  }
}