package onboarding;

/*
1. 문자열의 모든 문자 확인
    a. 알파벳이라면
        가. 대문자라면, 반대 대문자로 변환
        나. 소문자라면, 반대 소문자로 변환
 */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(char letter : word.toCharArray()){
            if((65 <= letter && letter <= 90) ||
                    (97 <= letter && letter <122)){
                char c = 0;
                if (letter <= 90)
                    c = (char) (65 + 90 - letter);
                else
                    c = (char) (97 + 122 - letter);
                answer += Character.toString(c);
            }
        }
        return answer;
    }
}
