package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    // **아쉬운점**
    // 모두 함수로 구현하려고 하였으나 3. 삭제 단계에서 무한루프가 계속 발생 => 거듭된 리팩토링에도 해결이 안되어 추후에 시도해보기
    // 연속 횟수를 구하는 function
    public static int overlap(String s){
        // overlap =  연속 횟수를 나타내는 변수
            int num = 0;
            for(int k = 0; k < s.length()-1; k++){
                char recent = s.charAt(k);
                char next = s.charAt(k+1);
                if(recent == next){
                    // 연속되는 글자 찾을 시 1씩 증가
                    num++;
                }
            }
            return num;
    }
    // unique한 값들을 저장할 list를 만드는 function
    public static void make(List<Character> l, String s){
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i))==i){
                l.add(s.charAt(i));
            }
        }
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        // 연속되는 글자가 사라질 때 까지 무한 루프
        while(true){
            // 1. 연속되는 글자 확인
            if(overlap(cryptogram) == 0) {
                // 연속되는 글자가 없을 시 루프 탈출
                break;
            }
            // 2. 삭제 준비
            // 2-1) cryptogram에서 unique한 원소값들만 넣을 배열 생성
            ArrayList<Character> list = new ArrayList<Character>();
            // 2-2) unique한 배열 원소로만 구성된 list 생성
            make(list, cryptogram);

            // 3. 삭제
            // unique한 원소를 차례대로 검증하여, 연속되면 삭제
            for(int j = 0; j < list.size(); j++){
                // 2회 이상 연속되는 패턴 생성
                String pattern = Character.toString(list.get(j)) + "{2,}";
                // 패턴이 존재할 시 삭제
                cryptogram = cryptogram.replaceAll(pattern, "");
            }
        }
        // 루프를 끝낸 문자열이 answer
        answer = cryptogram;
        return answer;
    }
}


