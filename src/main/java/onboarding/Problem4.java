package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character,Character> map = new HashMap<>();
        int alphaLength=26;
        int upperA=65,upperZ=90;
        int lowerA=97,lowerZ=122;
        //initAlpha
        for(int i=0;i<alphaLength;i++){
            map.put((char)(upperA + i),(char)(upperZ-i));
            map.put((char)(lowerA+i),(char)(lowerZ-i));
        }
        return answer;
    }
}
