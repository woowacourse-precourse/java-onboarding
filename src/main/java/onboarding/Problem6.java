package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> duplicateWords = new HashMap<>(); // word, email 저장, 중복 무시
        Set<String> duplicateEmailSet = new HashSet<>(); // email 저장, 중복 무시

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (nickname.length() != 1) { // 닉네임 한자리 수 제외
                List<String> nicknameWords = getNicknameWords(nickname);

                for (String word : nicknameWords) {
                    if (duplicateWords.containsKey(word)) {
                        duplicateEmailSet.add(email);
                        duplicateEmailSet.add(duplicateWords.get(word));
                    } else {
                        duplicateWords.put(word, email);
                    }
                }
            }
        }

        // 문자열 오름차순 정렬 후 리턴
        List<String> duplicateEmails = new ArrayList<>(duplicateEmailSet);
        duplicateEmails.sort(Comparator.naturalOrder());

        return duplicateEmails;
    }

    private static List<String> getNicknameWords(String nickname) {
        List<String> nicknameWords = new ArrayList<>();

        for (int i = 0; i < nickname.length(); i++) {
            for (int j = 2 + i; j < nickname.length() + 1; j++) {
                nicknameWords.add(nickname.substring(i, j));
            }
        }

        return nicknameWords;
    }
}
