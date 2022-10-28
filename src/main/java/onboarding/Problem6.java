package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
  public static List<String> solution(List<List<String>> forms) {
    List<String> nicknames = forms.stream().map(item -> item.get(1)).collect(Collectors.toList());
    Map<String, Set<String>> keywordStore = getKeywordStore(nicknames);
    Set<String> limitedNicknames = getLimitedNicknames(keywordStore);
    return getEmails(forms, limitedNicknames);
  }

  private static List<String> getEmails(List<List<String>> forms, Set<String> limitedNicknames) {
    List<String> emails = new ArrayList<>();
    for (List<String> form : forms) {
      if (limitedNicknames.contains(form.get(1))) {
        emails.add(form.get(0));
      }
    }
    Collections.sort(emails);
    return emails;
  }

  private static Set<String> getLimitedNicknames(Map<String, Set<String>> keywordStore) {
    Set<String> result = new HashSet<>();
    for (Map.Entry<String, Set<String>> names : keywordStore.entrySet()) {
      if (notLimitedNickname(names.getValue().size())) {
        continue;
      }
      names.getValue().stream().forEach(name -> result.add(name));
    }
    return result;
  }

  private static Map<String, Set<String>> getKeywordStore(List<String> nicknames) {
    Map<String, Set<String>> keywordStore = new HashMap<>();
    for (String name : nicknames) {
      for (int i = 0; i < name.length() - 1; i++) {
        String s = "" + name.charAt(i) + name.charAt(i + 1);
        if (keywordStore.containsKey(s)) {
          keywordStore.get(s).add(name);
          continue;
        }
        Set<String> nicknameStore = new HashSet<>();
        nicknameStore.add(name);
        keywordStore.put(s, nicknameStore);
      }
    }
    return keywordStore;
  }

  private static boolean notLimitedNickname(Integer nicknames) {
    return nicknames < 2;
  }
}
