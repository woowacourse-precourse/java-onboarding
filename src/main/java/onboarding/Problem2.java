package onboarding;

import java.util.*;

public class Problem2 {
    // **아쉬운점**
    // 1. 모두 함수로 구현하려고 하였으나 3. 삭제 단계에서 무한루프가 계속 발생 => 거듭된 리팩토링에도 해결이 안되어 추후에 시도해보기
    // 2. 삭제 준비 function을 생성할 때 void로 하였더니 지역변수 num이 초기화 되지 않는 문제 발생 + 전역변수로 선언해도 안됨
    // => int로 구현하여 반복횟수만 return하게끔 설정 (*list.add()는 그대로 진행되기 때문)

    // 삭제 준비 function(확인할 문자열, 빈 리스트, 연속횟수 셀 변수)
    public static int overlap(String s, List<Character> l, int n){
        for(int k = 0; k < s.length()-1; k++){
            char recent = s.charAt(k);
            char next = s.charAt(k+1);
            if(recent == next){ // 연속된다면
                // 연속되는 글자 찾을 시 n이 1씩 증가
                n += 1;
                // 연속되는 문자를 빈 리스트에 저장
                l.add(recent);
            }
        }
        return n;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        // 연속 횟수를 셀 num 선언
        int num;
        // 연속되는 글자가 사라질 때 까지 무한 루프
        while(true){
            // 1. 삭제 준비
            // 1-1) 초기화
            num = 0;
            // 연속 문자들만 넣을 배열 초기화
            ArrayList<Character> list = new ArrayList<Character>();

            // 1-2) 삭제 준비 function
            // 반복 횟수 설정
            num = overlap(cryptogram, list, num);
            
            // 1-3)삭제 list 유니크한 값들로 변환 (불필요한 작업 줄이기 위해서)
            ArrayList<Character> unique_list = new ArrayList<Character>(new HashSet<Character>(list));

            // **연속되는 글자가 없을 시 루프 탈출
            if(num == 0) {
                break;
            }

            // 2. 삭제
            // unique한 원소를 차례대로 검증하여, 연속되면 삭제
            for(int j = 0; j < unique_list.size(); j++){
                // 2회 이상 연속되는 패턴 생성
                String pattern = Character.toString(unique_list.get(j)) + "{2,}";
                // 패턴이 존재할 시 삭제
                cryptogram = cryptogram.replaceAll(pattern, "");
            }
        }
        // 루프를 끝낸 문자열이 answer
        answer = cryptogram;
        return answer;
    }
}


