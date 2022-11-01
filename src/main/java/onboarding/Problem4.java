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
        if (65 <= temp_ascii && temp_ascii <= 90) temp_ascii = 90 - (temp_ascii-65);
        if (97 <= temp_ascii && temp_ascii <= 122) temp_ascii = 122 - (temp_ascii-97);
        return (char)temp_ascii;
    }

    String getReversedString(String word){
        String temp_string = "";
        for (int i = 0; i < word.length(); i++){
            temp_string += getReversedAlphabet(word.charAt(i));
        }
        return temp_string;
    }


    public static String solution(String word) {
        Problem4 agent4 = new Problem4();
        String answer = agent4.getReversedString(word);
        return answer;
    }
}
