package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

class Form {

  private List<List<String>> forms = new ArrayList<>();
  private final HashSet<String> realAnswer = new HashSet<String>();
  private final List<HashSet<String>> parseEachName = new ArrayList<HashSet<String>>();

  Form(List<List<String>> form) {
    ValidityChecker vc = new ValidityChecker(form);
    this.forms = form;
  }

  List<String> getAnswer() {
    makeParseEachName();
    findOverlap(0, parseEachName.size(), 1);
    findOverlap(parseEachName.size() - 1, -1, -1);
    Iterator<String> iterator = realAnswer.iterator();

    List<String> answer = new ArrayList<>(realAnswer);
    answer.sort(Comparator.naturalOrder());
    return answer;

  }

  void makeParseEachName() {
    for (int i = 0; i < forms.size(); i++) {
      List<String> chunk = forms.get(i);
      HashSet<String> NameSubstring = getAllTwoWords(chunk.get(1));
      parseEachName.add(NameSubstring);
    }
  }

  HashSet<String> getAllTwoWords(String s) {
    HashSet<String> subStrings = new HashSet<String>();
    for (int i = 0; i < s.length() - 1; i++) {
      String parsedS = s.substring(i, i + 2);
      subStrings.add(parsedS);
    }
    return subStrings;
  }

  void findOverlap(int from, int to, int iterBy) {
    HashSet<String> parsedTotalSetDown = new HashSet<String>();
    for (int i = from; i != to; i = i + iterBy) {
      HashSet<String> hashEachName = new HashSet<String>();
      hashEachName = parseEachName.get(i);
      Iterator<String> it = hashEachName.iterator();
      for (String iter : hashEachName) {
        if (parsedTotalSetDown.contains(iter)) {
          realAnswer.add(forms.get(i).get(0));
        }
        parsedTotalSetDown.add(iter);
      }
    }
  }
}

class ValidityChecker {

  ValidityChecker(List<List<String>> input) {
    emailValidityCheck(input);
    nicknameValidityCheck(input);
    wordLengthValidityCheck(input);
  }

  private void emailValidityCheck(List<List<String>> input) {
    for (List<String> strings : input) {
      String[] emailFront = strings.get(0).split("@");
      if (emailFront.length != 2) {
        throw new IllegalArgumentException("email format doesn't satisfy forms");
      }
      if (!Pattern.matches("^[a-z0-9A-Z._-]*", emailFront[0])) {
        throw new IllegalArgumentException("email format doesn't satisfy forms");
      }
      if (!emailFront[1].equals("email.com")) {
        throw new IllegalArgumentException("email format doesn't satisfy forms");
      }
    }
  }
  private void nicknameValidityCheck(List<List<String>> input) {
    for (List<String> strings : input) {
      String nickName = strings.get(1);
      if (!Pattern.matches("[가-힣]*$", nickName)) {
        throw new IllegalArgumentException("Nickname is not Korean");
      }
    }
  }

  private void wordLengthValidityCheck(List<List<String>> input) {
    if (input.size() < 1 || input.size() > 10000) {
      throw new IllegalArgumentException("List length is not in range.");
    }
    for (List<String> strings : input) {
      String Nickname = strings.get(1);
      String Email = strings.get(0);
      if (Nickname.length() < 1 || Nickname.length() >= 20) {
        throw new IllegalArgumentException("Nickname length is not in range.");
      }
      if (Email.length() < 11 || Email.length() >= 20) {
        throw new IllegalArgumentException("email length is not in range.");
      }
    }
  }
}

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    Form form = new Form(forms);
    return form.getAnswer();
  }
}
