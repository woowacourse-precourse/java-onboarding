package onboarding;

/**
 * @Problem: 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
 */
public class Problem4 {
    public static String solution(String word) {
        return changeFrogString(word);
    }

    private static String changeFrogString(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char temp = changeFrogCharacter(word.charAt(i));
            answer.append(temp);
        }
        return answer.toString();
    }

    private static char changeFrogCharacter(char temp) {
        if ('a' <= temp && temp <= 'z'){
            temp = changeFrogLowerCase(temp);
        } else if('A' <= temp && temp <= 'Z') {
            temp = changeFrogUpperCase(temp);
        }
        return temp;
    }

    private static char changeFrogLowerCase(char temp) {
        return (char) ('z' - (temp - 'a'));
    }

    private static char changeFrogUpperCase(char temp) {
        return (char) ('A' - (temp - 'Z'));
    }
}
