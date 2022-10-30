package onboarding;

import java.util.List;
/*
제한 사항
    pobi와 crong의 길이는 2이다.
    pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.

기능 목록
1. 점수 계산 기능
2. answer 값 지정
3. 예외사항 구현
 */
class Problem1 {
    public static int score(int p){
        //1번 기능: 점수 계산 함수 구현
     int score;
     int add = p/100 + (p%100)/10 + (p%10);
     int multi;
     if(p/100 != 0) {
         multi = (p/100)*((p%100)/10)*(p%10);
     }else {
         multi = (p/10) * (p % 10);
     }
     if (add>multi){
         score = add;
     }else{
         score = multi;
     }
     return score;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int score_pobi = score(pobi.get(1));
        int score_crong = score(crong.get(1));
        return answer;
    }
}