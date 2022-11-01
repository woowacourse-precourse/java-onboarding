package onboarding;

public class Problem4 {
    public static String solution(String word) {

        // StringBuilder를 통하여 변경 가능한 문자열 생성
        StringBuilder answer = new StringBuilder(word);

        for (int i = 0; i < answer.length(); i++) {
            answer.setCharAt(i, flipWord(answer.charAt(i)));
        }

        return answer.toString();
    }

    // isUpperCase, isLowerCase로 대소문자 판별
    private static char flipWord(char letter) {
        
        char result = letter;

        if (Character.isUpperCase(letter))
            result = (char)('A' + ('Z' - letter));

        if (Character.isLowerCase(letter)) 
            result = (char)('a' + ('z' - letter));

        return result;
    }
}
