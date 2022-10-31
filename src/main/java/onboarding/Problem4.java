package onboarding;

/**
 * @Problem: 엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 메서드를 완성하라.
 */
public class Problem4 {
    public static String solution(String word) {
        return changeAlphabet(word);
    }

    private static String changeAlphabet(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i); // 현재 문자

            if (97 <= temp && temp <= 122){
                temp = changeFrogLowerCase(temp);
            } else if(65 <= temp && temp <= 90) {
                temp = changeFrogUpperCase(temp);
            }
            answer.append(temp);
        }
        return answer.toString();
    }

    private static char changeFrogLowerCase(char temp) {
        return (char) (122 - (temp - 97));
    }


    private static char changeFrogUpperCase(char temp) {
        return (char) (65 - (temp - 90));
    }
}
