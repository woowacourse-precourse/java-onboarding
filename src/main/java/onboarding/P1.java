package onboarding;

import java.util.List;
import java.util.stream.Stream;

public class P1 {
    public static void main(String[] args) {
        System.out.println(1);
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(297, 198);
        System.out.println(solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(numCalculation(pobi) == -1 || numCalculation(crong) == -1) {
            return answer = -1;
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