package onboarding;

public class Problem4 {
    static final int UPPER_TREE_FROG = 155;
    static final int LOWER_TREE_FROG = 219;

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        int wordLength = word.length();

        for (int index = 0; index < wordLength; index++) {
            char currentCharacter = word.charAt(index);

            if (isAlphabet(currentCharacter)) {
                currentCharacter = convertCharacter(currentCharacter);
            }

            answer.append(currentCharacter);
        }

        return answer.toString();
    }

    /*
    * 주어진 문자의 알파벳 여부를 반환
    *
    * @return boolean
    * */
    private static boolean isAlphabet(char character) {
        return (character >= 'A' && character <= 'Z')
                || (character >= 'a' && character <= 'z');
    }

    /*
    * 주어진 문자를 청개구리 사전에 따라 변환하여 반환
    * 대문자 여부에 따라 정해진 상수값 사용
    *
    * @return char
    * */
    private static char convertCharacter(char character) {
        if (Character.isUpperCase(character)) {
            return (char) (UPPER_TREE_FROG - character);
        }
        return (char) (LOWER_TREE_FROG - character);
    }
}
