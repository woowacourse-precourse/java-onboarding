package onboarding;

import onboarding.problem6.CustomException;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CustomException.checkException(forms);

        List<String> duplicatedCrew = new ArrayList<>();
        Map<String, String> nickNameCombination = new HashMap<>();

        for (List<String> crew : forms) {
            checkDuplicatedCombination(nickNameCombination, crew, duplicatedCrew);
        }

        Collections.sort(duplicatedCrew);
        return duplicatedCrew;
    }

    private static void checkDuplicatedCombination(Map<String, String> nickNameCombination, List<String> crew, List<String> duplicatedCrew) {
        String email = crew.get(0);
        String nickName = crew.get(1);

        for (int i = 0; i < nickName.length()-1; i++) {
            String letters = nickName.substring(i, i + 2);

            if (nickNameCombination.containsKey(letters)) {
                if (!duplicatedCrew.contains(email)) {
                    duplicatedCrew.add(email);
                }
                String emailOfDuplicatedLetters= nickNameCombination.get(letters);
                if (!duplicatedCrew.contains(emailOfDuplicatedLetters)) {
                    duplicatedCrew.add(emailOfDuplicatedLetters);
                }
            } else {
                nickNameCombination.put(letters, email);
            }
        }
    }
}
