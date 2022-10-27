package onboarding;

import java.util.*;
/*
* 1. 예외사항 체크 메소드 작성
* 2. 최댓값 메소드 작성
* 3. 점수 비교 메소드 작성
* 4. 점수 계산 및 결과 산출
* */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외사항
        if(exception(pobi, crong)){
            answer = -1;
        }
        else{
            //점수 계산
            int pobi_score = Math.max(make_max(pobi.get(0)), make_max(pobi.get(1)));
            int crong_score = Math.max(make_max(crong.get(0)), make_max(crong.get(1)));

            //결과 산출
            answer = compare(pobi_score, crong_score);
        }

        return answer;
    }

    // 예외사항 체크 메소드( 예외사항일때 true 리턴 )
    public static boolean exception(List<Integer> pobi, List<Integer>crong){
        if(pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1){
            return true;
        }
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)){
            return true;
        }
        if(pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400 ){
            return true;
        }
        return false;
    }

    // 최댓값 메소드
    public static int make_max(int num){
        int sum = 0;
        int mul = 1;

        while(num > 0){
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }
        return Math.max(sum, mul);
    }

    //점수 비교
    public static int compare(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return 2;
        } else {
            return 0;
        }
    }
}