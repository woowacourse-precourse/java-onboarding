package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder ans = new StringBuilder();
        ArrayList<String> answerList = new ArrayList<>();

        /**
         * 1번인 a를 26번인 z로
         * 2번인 b를 25번인 y로
         * 바꾸기 위한 방법인 26 - 알파벳 번호 + 1 = 원하는 알파벳 번호
         * 를 통해서 원하는 알파벳으로 바꾸는 과정
         */
        for(int i=0; i<word.length(); i++){
            char tmp = word.charAt(i);
            if(tmp >= 65 && tmp <= 90){
                tmp = (char)('Z' - tmp + 'A');
                ans.append(tmp);
            }
            else if(tmp >= 97 && tmp <= 122){
                tmp = (char)('z' - tmp + 'a');
                ans.append(tmp);
            }
            else ans.append(tmp);
        }
        answer = ans.toString();
        return answer;
    }
}
