package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int por =(int) (Math.random()*197+2)*2;    // 포비가 펼친 오른쪽 페이지
        int pol = por -1;                          // 포비가 펼친 왼쪽 페이지
        
        int crr =(int) (Math.random()*197+2)*2;    // 크롱이 펼친 오른쪽 페이지
        int crl = crr -1;                          // 크롱이 펼친 왼쪽 페이지
        
        
        
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}
