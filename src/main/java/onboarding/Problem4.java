package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static Map<Character,Character> initAlpha(){
        Map<Character,Character> map = new HashMap<>();
        int alphaLength=26;
        int upperA=65,upperZ=90;
        int lowerA=97,lowerZ=122;
        for(int i=0;i<alphaLength;i++){
            map.put((char)(upperA + i),(char)(upperZ-i));
            map.put((char)(lowerA+i),(char)(lowerZ-i));
        }
        return map;
    }
    public static String solution(String word) {
        String answer = "";
        Map<Character,Character> map = initAlpha();
        char[] wordArr = word.toCharArray();
        for(int i=0;i<wordArr.length;i++){
            if(!(wordArr[i] >= 'A' && wordArr[i] <= 'Z') && !(wordArr[i] >= 'a' && wordArr[i] <= 'z')){
                answer+=wordArr[i];
                continue;
            }
            answer+=map.get(wordArr[i]);
        }
        return answer;
    }
}
