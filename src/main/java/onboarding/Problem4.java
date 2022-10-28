package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int strToCharDigit = word.charAt(i);                //글자 하나를 불러온다.
            if (isAlphabet(answer, strToCharDigit)) continue;   //알파벳인지 체크

            strToCharDigit = distributeUpper(strToCharDigit);   //대소문자 구분
            answer.append(Character.toString(strToCharDigit));  //문자추가
        }
        return answer.toString();
    }

    /**
     * 대/소문자를 구분하여 문자변환을 하는 메소드
     * @param strToCharDigit
     * @return
     */
    private static int distributeUpper(int strToCharDigit) {
        if (Character.isUpperCase(strToCharDigit)) {
            strToCharDigit = (155 - strToCharDigit);
        } else {
            strToCharDigit = (219 - strToCharDigit);
        }
        return strToCharDigit;
    }

    /**
     * 알파벳인지 체크하는 메소드
     * @param answer
     * @param strToCharDigit
     * @return
     */
    private static boolean isAlphabet(StringBuilder answer, int strToCharDigit) {
        if (strToCharDigit == 32) {
            answer.append(Character.toString(strToCharDigit));
            return true;
        }
        return false;
    }
}
