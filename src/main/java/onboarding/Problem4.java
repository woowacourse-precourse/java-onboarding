package onboarding;

public class Problem4 {

    /**
     * 문자열을 청개구리 문자열로 바꿔줍니다.
     *
     * @param word 청개구리 문자열로 바꿀 문자열입니다.
     * @return 청개구리 문자열로 바뀐 문자열입니다.
     * */
    private static String encryptString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter: word.toCharArray()) {
            stringBuilder.append(encryptCharacter(letter));
        }
        return stringBuilder.toString();
    }

    /**
     * 문자 하나를 청개구리 문자로 바꿔줍니다.
     *
     * @param letter 청개구리 문자로 바꿀 문자입니다.
     * @return 바뀐 문자입니다. 영문자가 아닌 경우 그대로 반환합니다.
     * */
    private static String encryptCharacter(char letter) {
        if (!isAlphabet(letter)) {
            return String.valueOf(letter);
        }
        char oppositeLetter = getOppositeAlphabet(letter);
        return String.valueOf(oppositeLetter);
    }

    /**
     * 문자가 특정 범위안에 포함된 문자인지 확인합니다.
     *
     * @param letter 확인할 문자입니다.
     * @param leftBound 범위의 왼쪽 문자입니다.
     * @param rightBound 범위의 오른쪽 문자입니다.
     * @return 범위안에 있으면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean isBetween(char letter, char leftBound, char rightBound) {
        return leftBound <= letter && letter <= rightBound;
    }

    /**
     * 문자가 영문자인지 확인합니다.
     *
     * @param letter 확인할 문자입니다.
     * @return 문자가 영문자라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isAlphabet(char letter) {
        boolean isLower = isBetween(letter, 'a', 'z');
        boolean isUpper = isBetween(letter, 'A', 'Z');
        return isLower || isUpper;
    }

    /**
     * 청개구리 규칙을 적용해 반대 문자로 바꿔줍니다.
     *
     * @param letter 반대 문자로 바꿀 문자입니다.
     * @return 반대 문자로 바뀐 문자입니다.
     * */
    private static char getOppositeAlphabet(char letter) {
        char startLetter = 'a';
        char endLetter = 'z';
        boolean isUpper = isBetween(letter, 'A', 'Z');
        if (isUpper){
            startLetter = 'A';
            endLetter = 'Z';
        }
        char oppositeLetter = (char) (endLetter - letter + startLetter);
        return oppositeLetter;
    }

    /**
     * Problem4의 솔루션 코드입니다.
     *
     * @param word 청개구리 문자열로 바꿀 문자열입니다.
     * @return 청개구리 문자열로 바뀐 문자열입니다.
     * */
    public static String solution(String word) {
        String answer = encryptString(word);
        return answer;
    }
}
