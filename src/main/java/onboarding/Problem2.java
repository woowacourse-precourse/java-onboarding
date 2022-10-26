package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = deleteDuplicatedCharacter(cryptogram);
        return answer;
    }

    private static String deleteDuplicatedCharacter(String cryptogram) {

        StringBuilder cryptogramStringBuilder = new StringBuilder(cryptogram);

        while (cryptogramStringBuilder.length() != 0) {

            HashSet<Integer> duplicatedCharacterIndexes = findDuplicatedCharacterIndex(cryptogramStringBuilder);
            if(duplicatedCharacterIndexes.isEmpty()) break;
            cryptogramStringBuilder = duplicatedCharacterToBlankByIndex(cryptogramStringBuilder, duplicatedCharacterIndexes);
            cryptogramStringBuilder = new StringBuilder(cryptogramStringBuilder.toString().replace(" ", ""));
        }

        return cryptogramStringBuilder.toString();
    }

    private static StringBuilder duplicatedCharacterToBlankByIndex(StringBuilder cryptogramStringBuilder, HashSet<Integer> duplicatedCharacterIndexes) {
        for (int num : duplicatedCharacterIndexes) {
            cryptogramStringBuilder.setCharAt(num, ' ');
        }
        return cryptogramStringBuilder;
    }

    private static HashSet<Integer> findDuplicatedCharacterIndex(StringBuilder cryptogramStringBuilder) {
        HashSet<Integer> duplicatedCharacterIndexes = new HashSet<Integer>();

        for (int i = 1; i < cryptogramStringBuilder.length(); i++) {
            if (cryptogramStringBuilder.charAt(i-1) != cryptogramStringBuilder.charAt(i)) continue;

            duplicatedCharacterIndexes.add(i);
            duplicatedCharacterIndexes.add(i-1);
        }

        return duplicatedCharacterIndexes;
    }
}
