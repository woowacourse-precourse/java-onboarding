package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 큰 틀의 기능 구현
 * 1. [50000,10000,5000,1000,500,100,50,10] 클래스 변수 생성 함수
 * 2.  입력값 체크하는 함수
 * 3.  몫을 이용한 result 값 저장
 * **/

/**
 * 1.[50000,10000,5000,1000,500,100,50,10] 클래스 변수 생성 함수
 * - 홀수 (횟수) : / 5 , 짝수 (횟수) : /2 홀수 판별 함수 필요 , 마지막 10원->1원 예외처리
 * **/




public class Problem5 {
    static private List<Integer> unitsList = new ArrayList<>();
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static void main(String[] args) {
        makeUnitsList();
        System.out.println(unitsList);
    }

    private static int distinguishOdd(int inputNum){
        if(inputNum == 7)
            return 10;
        if(inputNum %2 == 1)
            return 2;
        return 5;
    }

    private static void makeUnitsList() {
        int unit = 50000;
        for (int i = 0; i < 9; i++) {
            unitsList.add(unit);
            unit /= distinguishOdd(i);
        }
    }
}
