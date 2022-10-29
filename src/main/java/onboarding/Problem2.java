package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    /* compare: 중복 문자가 존재하는지 확인하는 함수 */
    public static boolean compare(List<Character> chr){
        for(int i=0; i<chr.size()-1; i++){
            if(chr.get(i)==chr.get(i+1)) return true;
        }
        return false;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";

        //String을 List<Character>으로 변환
        List<Character> cyp = new ArrayList<Character>();
        for(int i=0; i<cryptogram.length(); i++){
            cyp.add(cryptogram.charAt(i));
        }

        while(compare(cyp)){

        }

        return answer;
    }
}