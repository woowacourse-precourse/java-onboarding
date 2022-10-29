package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>();

        int startIdx=0;

        for(int i=0; i<str.length; i++){
            strList.add(str[i]);
        }

        // duplication start Index
        for (int i = 0; i < strList.size()-1; i++) {
            if(strList.get(i).equals(strList.get(i+1))){
                startIdx=i;
                break;
            }
        }

        return answer;
    }
}
