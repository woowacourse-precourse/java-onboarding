package onboarding;

public class Problem4 {

    /*
     * 입력이 유효한지 판별합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 문자열이 유효하다면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isValidInput(String word) {
        boolean valid = hasValidLength(word);
        return valid;
    }

    /*
     * 문자열의 길이가 1~1000인지 확인합니다.
     *
     * @param 입력으로 주어진 문자열입니다.
     * @return 길이가 1~1000 사이라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean hasValidLength(String word) {
        boolean valid = word.length() > 0 &&
                word.length() <= 1000;
        return valid;
    }

    /*
     * 문자열을 청개구리 문자열로 바꿔줍니다.
     *
     * @param 바꿀 문자열입니다.
     * @return 바뀐 문자열입니다.
     * */
    private static String encryptString(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter: word.toCharArray()) {
            stringBuilder.append(encryptCharacter(letter));
        }
        return stringBuilder.toString();
    }

    /*
     * 문자 하나를 청개구리 문자로 바꿔줍니다.
     *
     * @param 바꿀 문자입니다.
     * @return 바뀐 문자입니다. 알파벳이 아닌 경우 그대로 반환합니다.
     * */
    private static String encryptCharacter(char letter) {
        if (isAlphabet(letter) == false) {
            return String.valueOf(letter);
        }
        char oppositeLetter = getOppositeAlphabet(letter);
        return String.valueOf(oppositeLetter);
    }

    /*
     * 문자가 특정 범위의 문자인지 확인합니다.
     *
     * @param 확인할 문자, 범위의 왼쪽 문자, 범위의 오른쪽 문자입니다.
     * @return 범위안에 있으면 참, 아니면 거짓을 반환합니다.
     */
    private static boolean isBetween(char letter, char leftBound, char rightBound) {
        return leftBound <= letter && letter <= rightBound;
    }

    /*
     * 문자가 영문자인지 확인합니다.
     *
     * @param 확인할 문자입니다.
     * @return 문자가 영문자라면 참, 아니면 거짓을 반환합니다.
     * */
    private static boolean isAlphabet(char letter) {
        boolean isLower = isBetween(letter, 'a', 'z');
        boolean isUpper = isBetween(letter, 'A', 'Z');
        return isLower || isUpper;
    }

    /*
     * 문자를 반대 문자로 바꿔줍니다.
     *
     * @param 반대 문자로 바꿀 문자입니다.
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

    /*
     * Problem4의 솔루션 코드입니다.
     *
     * @param 청개구리 문자열로 바꿀 문자열입니다.
     * @return 청개구리 문자열로 바뀐 문자열입니다.
     * */
    public static String solution(String word) {
        if (isValidInput(word) == false) {
            return "Error: Wrong input";
        }
        String answer = encryptString(word);
        return answer;
    }
}
