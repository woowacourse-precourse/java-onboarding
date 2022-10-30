package problem6;

import java.util.*;

public class Forms {

    private List<List<String>> forms;

    public Forms(List<List<String>> forms) {
        this.forms = forms;
    }

    private Map<String, Integer> saveConsecutiveCharacter() {
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = getNickname(i);
            countConsecutiveCharacter(count, nickname);
        }

        return count;
    }

    private void countConsecutiveCharacter(HashMap<String, Integer> count, String nickname) {
        for (int j = 0; j < nickname.length() - 1; j++) {
            count(count, nickname, j);
        }
    }

    private void count(HashMap<String, Integer> count, String nickname, int start) {
        for (int k = start + 1; k < nickname.length(); k++) {
            addCount(count, getKey(nickname, start, k));
        }
    }

    private void addCount(HashMap<String, Integer> count, String key) {
        count.put(key, count.getOrDefault(key, 0) + 1);
    }

    private String getKey(String nickname, int start, int k) {
        return nickname.substring(start, k + 1);
    }

    private String getNickname(int index) {
        return forms.get(index).get(1);
    }
}
