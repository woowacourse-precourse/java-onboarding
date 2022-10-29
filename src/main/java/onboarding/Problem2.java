package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>();

        for(int i=0; i<str.length; i++){
            strList.add(str[i]);
        }

        return answer;
    }
}
