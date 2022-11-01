package onboarding;

public class Problem2 {
    private static boolean state = true;

    public static String solution(String cryptogram) {
        String answer = "";
        initState();

        while (state) {
            state = false;

            answer = getAnswerWithoutDuplicate(cryptogram);

            cryptogram = answer;
        }

        return answer;
    }

    private static void initState() {
        state = true;
    }

    private static String getAnswerWithoutDuplicate(String cryptogram) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            char currentCharacter = cryptogram.charAt(i);
            char frontCharacter = getFrontCharacter(i, cryptogram);
            char backCharacter = getBackCharacter(i, cryptogram);

            boolean isDuplicate = isSameCharacter(currentCharacter, frontCharacter) ||
                    isSameCharacter(currentCharacter, backCharacter);

            if (!isDuplicate) {
                answer.append(cryptogram.charAt(i));
            } else {
                state = true;
            }
        }

        return answer.toString();
    }

    private static char getFrontCharacter(int index, String cryptogram) {
        if (index == 0) {
            return ' ';
        }

        return cryptogram.charAt(index - 1);
    }

    private static char getBackCharacter(int index, String cryptogram) {
        if (index == cryptogram.length() - 1) {
            return ' ';
        }

        return cryptogram.charAt(index + 1);
    }

    private static boolean isSameCharacter(char character1, char character2) {
        return character1 == character2;
    }
}
