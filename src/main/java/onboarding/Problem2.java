package onboarding;

import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {

        //String preCryptogram = cryptogram;
        deleteDuplicatedCharacter(cryptogram);


        String answer = "answer";
        return answer;
    }

    private static void deleteDuplicatedCharacter(String cryptogram) {

        StringBuilder cryptogramStringBuilder = new StringBuilder(cryptogram);

        while (cryptogramStringBuilder.length() != 0) {

            HashSet<Integer> duplicatedCharacterSets;

            duplicatedCharacterSets = findDuplicatedCharacterIndex(cryptogramStringBuilder);

        }
    }

    private static HashSet<Integer> findDuplicatedCharacterIndex(StringBuilder cryptogramStringBuilder) {
        HashSet<Integer> duplicatedCharacterSets = new HashSet<Integer>();

        for (int i = 1; i < cryptogramStringBuilder.length(); i++) {
            if (cryptogramStringBuilder.charAt(i-1) != cryptogramStringBuilder.charAt(i)) continue;

            duplicatedCharacterSets.add(i);
            duplicatedCharacterSets.add(i-1);
        }

        return duplicatedCharacterSets;
    }
}
