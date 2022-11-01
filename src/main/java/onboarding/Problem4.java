/*
기능 목록
i) getReversedAlphabet -> Ascii 코드를 이용하여 입력받은 char 을 변형하여 표에 맞춘 문자를 반환함
ii) getReversedString -> i) 을 이용하여 문장 전체를 변형한 뒤 반환함.
iii) solution -> ii) 을 이용하여 정답 반환
 */

package onboarding;

public class Problem4 {

    char getReversedAlphabet(char alpha_bet){
        int temp_ascii = (int)alpha_bet;
        temp_ascii = 90 - (temp_ascii-65);
        return (char)temp_ascii;
    }


    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
