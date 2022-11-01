package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

  public static List<String> solution(List<List<String>> forms) {
    List<String> answer;
    Set<String> emailSet = new HashSet<>();
    Map<String, String> tokenMap = new HashMap<>();

    for (List<String> entry : forms) {
      String email = entry.get(0);
      String nickname = entry.get(1);

      for (int i = 0; i < nickname.length() - 1; i++) {
        String token = nickname.substring(i, i + 2);
        if (tokenMap.containsKey(token)) {
          emailSet.add(email);
          emailSet.add(tokenMap.get(token));
        }
        tokenMap.put(token, email);
      }
    }
    answer = new ArrayList<>(emailSet);
    Collections.sort(answer);
    return answer;
  }
}
