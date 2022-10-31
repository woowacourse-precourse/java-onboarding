package onboarding;

public class Problem4 {

    /**
     * word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하는 solution 메서드
     * @param word 엄마의 말씀
     * @return word를 반대로 변환한 값
     */
    public static String solution(String word) {
        String answer = "";
        if (!isValid(word)) return "error";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char result = conversionWord(c);
            answer += result;
        }
        return answer;
    }

    /**
     * 단어의 제한사항 확인
     * @param word 엄마의 말씀
     * @return 제한 조건에 적합할 경우 true, 제한 조건에 위배될 경우 false
     */
    public static boolean isValid(String word) {
        if (word.length() < 1 || word.length() > 1000) return false;
        return true;
    }

    /**
     * 글자가 알파벳이 맞는지 확인하는 method
     * @param c word 중 한 글자
     * @return 알파벳인 경우 true, 알파벳이 아닌 경우 false
     */
    public static boolean isAlphabet(char c) {
        if (('a'<= c && c <= 'z') || ('A'<= c && c <= 'Z')) return true;
        return false;
    }

    /**
     * 청개구리 사전을 참고해 글자를 반환하는 method
     * @param c 엄마의 말씀 중 한 글자
     * @return 반대로 변환한 글자
     */
    public static char conversionWord(char c) {
        if (!isAlphabet(c)) return c;
        if ('a'<= c && c <= 'z') return (char) ('z' + 'a' - c);
        return (char) ('Z' + 'A' - c);
    }
}
