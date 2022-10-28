package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "answer";

        Map<Character, Character> map = new HashMap<>();

        int idx =0;

        for(int i='A'; i<='Z'; i++ ){
            map.put((char) i,(char)('Z'-idx++));
        }
        idx =0;
        for(int i='a'; i<='z'; i++){
            map.put((char) i,(char)('z'-idx++));
        }


        return answer;
    }
}


//A = 65 66 67 68 69 70 71 72 73 74 75 76 77 78
//Z = 90 89 88 87 86 85 84 83 82 81 80 79 78 77
