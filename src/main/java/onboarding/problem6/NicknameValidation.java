package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameValidation {
  private final Map<String, Set<String>> keywordOfNickname = new HashMap<>();

  public List<String> validate(List<String> nicknames) {
    initializeStore(nicknames);
    return getDuplicateNicknames();
  }

  private List<String> getDuplicateNicknames() {
    return keywordOfNickname.entrySet().stream()
            .filter(nicknames -> duplicateNickname(nicknames.getValue().size()))
            .flatMap(nicknames -> nicknames.getValue().stream())
            .distinct()
            .collect(Collectors.toList());
  }

  private void initializeStore(List<String> nicknames) {
    nicknames.stream().forEach(nickname -> IntStream.range(0, nickname.length() - 1)
            .forEach(idx -> this.setKeywordAndNickname(getKeyword(nickname, idx), nickname)));
  }

  private boolean duplicateNickname(Integer nicknames) {
    return nicknames >= 2;
  }

  private void setKeywordAndNickname(String keyword, String nickname) {
    if (keywordOfNickname.containsKey(keyword)) {
      keywordOfNickname.get(keyword).add(nickname);
      return;
    }
    Set<String> nicknames = new HashSet<>();
    nicknames.add(nickname);
    keywordOfNickname.put(keyword, nicknames);
  }

  private String getKeyword(String nickname, int idx) {
    return String.valueOf(nickname.charAt(idx)) + nickname.charAt(idx + 1);
  }
}
