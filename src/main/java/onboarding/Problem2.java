package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            int index = overlap.get(0); //중복시작되는 인덱스 저장
            for(int i=0; i<overlap.size(); i++){ //중복된 문자 제거
                cyp.remove(index); //삭제 후 인덱스가 줄기 때문에 index 고정하고 중복 숫자만큼 삭제한다.
            }
        }

        answer = cyp.stream().map(String::valueOf).collect(Collectors.joining());

        return answer;
    }
}