package onboarding;

import java.util.List;
import java.util.stream.Stream;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(numCalculation(pobi) == -1 || numCalculation(crong) == -1) {
            answer = -1;
        }
        else {
            if (numCalculation(pobi) > numCalculation(crong)) {
                answer = 1;
            } else if (numCalculation(pobi) < numCalculation(crong)) {
                answer = 2;
            } else if (numCalculation(pobi) == numCalculation(crong)) {
                answer = 0;
            }
            /** 예외처리 페이지 숫자가 연속되지 않는다면*/
        }

        return answer;
    }

    public static int numCalculation(List<Integer> lst) {
        /**
         * 요구사항 6번
         * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다. - 구현하기
         * [1,2] , [399,400] 을 펼치면 안됨,  시작 페이지나 마지막 페이지를
         * 바로 열어버리면 랜덤하게 여는게 아니라 앞이나 뒤에서 한장만 쓱 넘기는 거라 게임 룰에 위반되므로
         */
        if(lst.get(0)+1 == lst.get(1))
            if(bigNumber(lst.get(0))>bigNumber(lst.get(1))) {
                return bigNumber(lst.get(0));
            } else return bigNumber(lst.get(1));
        else return -1;
    }

    public static int bigNumber(int a) { //실제 숫자
        int[] arrNum = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::parseInt).toArray();
        int addResult = 0;
        int multiplyResult = 1;
        for(int i=0; i< arrNum.length; i++) {
            int tmp = arrNum[i];
            addResult += tmp;
        }
        for(int i=0; i< arrNum.length; i++) {
            int tmp = arrNum[i];
            multiplyResult *= tmp;
        }
        if(addResult>multiplyResult) {
            return addResult;
        } else return multiplyResult;
    }
}