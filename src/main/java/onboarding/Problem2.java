package onboarding;

public class Problem2 {
    static boolean state = true;

    public static String solution(String cryptogram) {
        String answer = "";

        while (state) {
            state = false;

            answer = getAnswerWithoutDuplicate(cryptogram);

            cryptogram = answer;
        }

        return answer;
    }

    private static String getAnswerWithoutDuplicate(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        boolean isDuplicate;

        for (int i = 0; i < cryptogram.length(); i++) {
            char currentCharacter = cryptogram.charAt(i);
            char frontCharacter;
            char backCharacter;

            if (i == 0) {
                backCharacter = cryptogram.charAt(i + 1);
                isDuplicate = isDuplicateCharacter(currentCharacter, backCharacter);
            } else if (i == cryptogram.length() - 1) {
                frontCharacter = cryptogram.charAt(i - 1);
                isDuplicate = isDuplicateCharacter(currentCharacter, frontCharacter);
            } else {
                frontCharacter = cryptogram.charAt(i - 1);
                backCharacter = cryptogram.charAt(i + 1);
                isDuplicate = isDuplicateCharacter(currentCharacter, frontCharacter) || isDuplicateCharacter(currentCharacter, backCharacter);
            }

            if (!isDuplicate) {
                answer.append(cryptogram.charAt(i));
            } else {
                state = true;
            }
        }

        return answer.toString();
    }

    private static boolean isDuplicateCharacter(char character1, char character2) {
        return character1 == character2;
    }
}
