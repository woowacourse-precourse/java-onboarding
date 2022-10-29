package onboarding;

import java.util.List;

public class Problem3 {
    // 특정 문자 개수 세는 funtion
    public static int Count(String s, char ch){
        // 기존 문자열 길이 - 셀 문자를 뺀 문자열 길이
        return s.length() - s.replace(String.valueOf(ch),"").length();
    }
    public static int solution(int number) {
        int answer = 0;
        // 1 ~ number까지 루프
        for(int i = 1; i<= number; i++){
            // 문자열로 변환
            String new_n = Integer.toString(i);
            // 3,6,9의 개수 더한 값 = 해당 값에서 박수 계산
            int clap = Count(new_n, '3') + Count(new_n, '6') + Count(new_n, '9');
            // 박수 누적 추가 = 정답
            answer += clap;
        }
        return answer;
    }
}
