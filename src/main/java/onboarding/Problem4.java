package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = convert(word);
        return answer;
    }

    /**
     * 입력받은 문자열을 청개구리 사전에 맞추어 변환
     * @param {String} word
     * @return {string} result
     */
    public static String convert(String word) {
        String result = "";

        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c)) {
                result += (char) (155 - c);
            }
            else if(Character.isLowerCase(c)) {
                result += (char) (219 - c);
            }
            else result += c;
        }
        return result;
    }
}
