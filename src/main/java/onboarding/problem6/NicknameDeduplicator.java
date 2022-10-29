package onboarding.problem6;

import java.util.*;

public class NicknameDeduplicator {
    public final Map<String, Set<String>> DICTIONARY = new HashMap<>();

    public NicknameDeduplicator(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            for (int i = 0; i < nickName.length() - 1; i++) {
                String _2gram = nickName.substring(i, i + 2);
                Set<String> emails = DICTIONARY.getOrDefault(_2gram, new HashSet<>());
                emails.add(email);
                DICTIONARY.put(_2gram, emails);
            }
        }
    }

    public List<String> getDuplicatedCrewsEmail() {
        Set<String> resultSet = new HashSet<>();
        for (Set<String> emails : DICTIONARY.values()) {
            if (emails.size() > 1)
                resultSet.addAll(emails);
        }
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
