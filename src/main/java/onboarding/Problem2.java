package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char [] charArr = cryptogram.toCharArray();
        ArrayList<Character> charArr2 = new ArrayList<>();
        for(char i : charArr){
            if(!charArr2.contains(i)){
                charArr2.add(i);
            }
        }
        for(char x : charArr2){
            answer += x;
        }
        return answer;
    }
}
