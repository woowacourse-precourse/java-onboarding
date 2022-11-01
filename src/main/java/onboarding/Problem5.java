package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 큰 틀의 기능 구현
 * 1. [50000,10000,5000,1000,500,100,50,10] 클래스 변수 생성 함수
 * 2.  입력값 체크하는 함수
 * 3.  몫을 이용한 result 값 반환
 * **/

/**
 * 1.[50000,10000,5000,1000,500,100,50,10] 클래스 변수 생성 함수
 * - 홀수 (횟수) : / 5 , 짝수 (횟수) : /2 홀수 판별 함수 필요 , 마지막 10원->1원 예외처리
 * - class 변수를 통해 단위배열 생성 함수
 * **/

/**
 * 2. 입력값 체크하는 함수
 * - 입력값이 잘못 들어왔을 때 -> if문을 통해 collections.emptyList 반환 해줄려고 잘 들어오면 false 잘못 들어오면 true로 설정
 * **/


public class Problem5 {
    static private List<Integer> unitsList = new ArrayList<>();
    public static List<Integer> solution(int money) {
        makeUnitsList();
        List<Integer> answer = convertMoney(money);
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

    private static boolean checkInput(int inputMoney){
        if (inputMoney < 1 || inputMoney > 1000000)
            return true;
        return false;
    }

    private static List<Integer> convertMoney(int inputMoney){
        if(checkInput(inputMoney))
            return Collections.emptyList();
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < unitsList.size(); i++)
        {
            ret.add(inputMoney/unitsList.get(i));
            inputMoney = inputMoney%unitsList.get(i);
        }
        unitsList.clear();
        return ret;
    }
}
