package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        // 27 - 1 = 26, 27 - 26 = 1 인걸 이용할거임
        String answer = "";
        StringBuilder ans = new StringBuilder();
        ArrayList<String> answerList = new ArrayList<>();

        for(int i=0; i<word.length(); i++){
            char tmp = word.charAt(i);
            if(tmp >= 65 && tmp <= 90){
                tmp = (char)('[' - tmp + 'A');
                ans.append(tmp);
            }
            else if(tmp >= 97 && tmp <= 122){
                tmp = (char)('{' - tmp + 'a');
                ans.append(tmp);
            }
            else ans.append(tmp);
        }
        answer = ans.toString();
        return answer;
    }
}
