package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(verificationNumber(pobi)<0 || verificationNumber(crong)<0){
            answer=-1;
            return answer;
        }
        //유저의 최대값 계산
        int firstUserScore = Math.max(numMaxSumMul(pobi.get(0)),numMaxSumMul(pobi.get(1)));
        int SecondUserScore = Math.max(numMaxSumMul(crong.get(0)),numMaxSumMul(crong.get(1)));

        answer = calResult(answer, firstUserScore, SecondUserScore);
        return answer;
    }
    //페이지 유효성 검사
    private static int verificationNumber(List<Integer> page){
        if(page.size()!=2){ // 입력 page의 값이 2개인지
            return -1;
        }
        if(page.get(1)-page.get(0)!=1) { // page 의 차이가 1이여야 한다.
            return -1;
        }
        if(page.get(0)<=1 || page.get(1)>=400){ //page 의 범위는 1~400, 하지만 시작면이나 마지막면이 나오도록 책을 펼치지 않음
            return -1;
        }
        if(page.get(0)%2 == 0 || page.get(1)%2 == 1){ //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
            return -1;
        }
        return 0;
    }
    //페이지의 각자리 덧셈,곱셈 함수
    private static int numMaxSumMul(int page){
        int sum=0, mul=1;
        while (page>0){
            sum += page%10;
            mul *= page%10;
            page /= 10;
        }
        return Math.max(sum,mul);
    }
    //결과 계산
    private static int calResult(int answer, int firstScore, int secondScore){
        if(firstScore>secondScore){
            answer = 1;
        }
        else if(firstScore<secondScore){
            answer = 2;
        }
        else if(firstScore==secondScore){
            answer =0;
        }
        return answer;
    }
}