package onboarding;

import java.util.*;

public class Problem6 {

    private static final int WORD_LENGTH = 2;
    private static Map<String, Integer> duplicatedCountPerWord = new HashMap<>();
    private static Set<String> emailsOfCrewWhoHasDuplicatedNickName = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            makeLengthTwoWordsBag(crew.get(1));
        }

        for (List<String> crew : forms) {
            findCrewWhoHasDuplicatedNickName(crew);
        }

        List<String> answer = getSortedEmails();
        return answer;
    }

    private static void makeLengthTwoWordsBag(String nickName) {
        int nickNameLength = nickName.length();
        nickNameLength--;
        for (int i = 0; i < nickNameLength; i++) {
            savePartialWordsToMap(nickName.substring(i, i + WORD_LENGTH));
        }
    }

    private static void savePartialWordsToMap(String partialWord) {
        if (!duplicatedCountPerWord.containsKey(partialWord)) {
            duplicatedCountPerWord.put(partialWord, 0);
        }
        Integer duplicatedCount = duplicatedCountPerWord.get(partialWord);
        duplicatedCountPerWord.put(partialWord, duplicatedCount + 1);
    }

    private static void findCrewWhoHasDuplicatedNickName(List<String> crew) {
        String email = crew.get(0);
        String nickName = crew.get(1);
        int nickNameLength = nickName.length();
        nickNameLength--;
        for (int i = 0; i < nickNameLength; i++) {
            saveEmailOfDuplicatedNickName(nickName.substring(i, i + WORD_LENGTH), email);
        }
    }

    private static void saveEmailOfDuplicatedNickName(String partialWord, String email) {
        Integer duplicatedCount = duplicatedCountPerWord.get(partialWord);
        if (duplicatedCount > 1) {
            emailsOfCrewWhoHasDuplicatedNickName.add(email);
        }
    }

    private static List<String> getSortedEmails() {
        List<String> emails = new LinkedList<>(emailsOfCrewWhoHasDuplicatedNickName);
        Collections.sort(emails);
        return emails;
    }
}
