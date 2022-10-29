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
            boolean same = false;
            List<Integer> overlap = new ArrayList<>();
            for(int i=0; i<cyp.size()-1; i++){
                if(cyp.get(i)==cyp.get(i+1)){ //앞,뒤 문자가 중복이라면 index 저장
                    same = true;
                    overlap.add(i);
                    overlap.add(i+1);
                }
                if(same & cyp.get(i)!=cyp.get(i+1)){ //연속하는 중복 문자가 끝난 경우 for문 종료
                    break;
                }
            }

        }

        return answer;
    }
}