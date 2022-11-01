package custom.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateCheckResolver {

    private final Map<String, String> wordMap = new HashMap<>();
    private final Set<String> duplicateNicknameSet = new HashSet<>();

    public Set<String> findDuplicateForm(List<Form> buffer) {
        for (Form form : buffer) {
            String email = form.getEmail();
            String nickname = form.getNickname();
            for (int j = 0; j < nickname.length() - 1; ++j) {
                String word = nickname.substring(j, j + 2);
                if (wordMap.containsKey(word)) {
                    addDuplicateNickname(email, word);
                }
                wordMap.put(word, email);
            }
        }
        Set<String> answer = new HashSet<>(duplicateNicknameSet);
        duplicateNicknameSet.clear();
        return answer;
    }

    private void addDuplicateNickname(String email, String word) {
        duplicateNicknameSet.add(email);
        duplicateNicknameSet.add(wordMap.get(word));
    }
}
