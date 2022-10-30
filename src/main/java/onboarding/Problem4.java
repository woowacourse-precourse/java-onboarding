package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // letter: 현재 보고있는 문자
        char letter;
        // sb: 문자열 생성을 위한 빌더
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            // 현재 문자가 대문자라면 반대되는 대문자로 변환
            if(letter >= 'A' && letter <= 'Z')
                letter = (char)('A' + 'Z' - letter);
            // 현재 문자가 소문자라면 반대되는 소문자로 변환
            else if(letter >= 'a' && letter <= 'z')
                letter = (char)('a' + 'z' - letter);

            sb.append(letter);
        }
        answer = sb.toString();

        return answer;
    }
}
