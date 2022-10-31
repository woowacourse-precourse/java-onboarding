package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int TWO_DIGIT_INDEX = 2;
    private static final int DUPLICATED_SIZE = 2;

    public static List<String> solution(List<List<String>> forms) {
        Set<String> nicknameList = new LinkedHashSet<>();
        Map<String, List<String>> duplicateMap = new HashMap<>();

        for (List<String> userInfo : forms) {
            String email = userInfo.get(0);
            String nickname = userInfo.get(1);
            createCombination(nickname, nicknameList, duplicateMap, email);
        }

        Set<String> deduplicatedEmail = new LinkedHashSet<>();
        addValueToSet(duplicateMap, deduplicatedEmail);

        return getSortedEmail(deduplicatedEmail);
    }

    private static List<String> getSortedEmail(Set<String> deduplicatedEmail) {
        return deduplicatedEmail.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void createCombination(String nickname, Set<String> nicknameList, Map<String, List<String>> duplicateMap, String email) {
        int startIdx = 0;
        while (startIdx != nickname.length() - 1) {
            String twoDigit = getTwoDigitName(nickname, startIdx++);
            nicknameList.add(twoDigit);
            addEmailToMap(duplicateMap, twoDigit, email);
        }
    }

    private static void addValueToSet(Map<String, List<String>> duplicateMap, Set<String> duplicatedEmail) {
        duplicatedEmail.addAll(duplicateMap.values().stream()
                .filter(emailList -> emailList.size() >= DUPLICATED_SIZE)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    private static void addEmailToMap(Map<String, List<String>> duplicateMap, String twoDigit, String email) {
        duplicateMap.compute(twoDigit, (k, v) -> v == null ? new ArrayList<>() : v).add(email);
    }

    private static String getTwoDigitName(String nickname, int startIdx) {
        return nickname.substring(startIdx, startIdx + TWO_DIGIT_INDEX);
    }
}
