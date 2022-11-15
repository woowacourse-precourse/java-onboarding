package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        ArrayList<Character> list = new ArrayList<Character>();
        //다시한번 쪼개보자 넥슬라이스!
        for(int i=0 ; i<word.length() ; i++){
            list.add(word.charAt(i));
        }

        String answer = "";
        //인간적으로 아스키코드 몇개는 외우자 스페이스:32 A:65 Z:90 a:97 z:122 <- 알파벳 몇개인지 모르면 걍 다 외우자!
        for(Character item : list){
            if ((int)item < 65) {
                answer += " ";
            }
            else if ((int)item < 97){
                int a = 155 - (int)item;
                answer += (char)a;
            }
            else {
                int a = 219 - (int)item;
                answer += (char)a;
            }
        }
        return answer;
    }
}
