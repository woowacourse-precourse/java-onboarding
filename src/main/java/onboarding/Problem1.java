package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //유효성 검사
        boolean validValuePobi = isValid(pobi);
        boolean validValueCrong = isValid(crong);

        if(!(validValuePobi && validValueCrong)) {
            return -1;
        }

        List<Integer> pobiCalculationResult = Arrays.asList(sum(pobi), mul(pobi));
        List<Integer> crongCalculationResult = Arrays.asList(sum(crong), mul(crong));

        int pobiFinalValue = Collections.max(pobiCalculationResult);
        int crongFinalValue = Collections.max(crongCalculationResult);

        int answer =  winnerResult(pobiFinalValue, crongFinalValue);

        return answer;
    }

    /*
    예외사항 확인
    배열 값의 크기는 1 차이가 나야 유효한 값으로 인정한다.
    */
    static private boolean isValid(List<Integer> testingArr) {

        if (Math.abs(testingArr.get(0) - testingArr.get(1)) != 1) {
            return false;
        }
        else {
            return true;
        }

    }

    //Integer형 List가 인자로 들어왔을 때, 합을 계산하여 큰 값을 리턴
    static private int sum(List<Integer> sumArr) {

        int firSumValue = 0;
        int secSumValue = 0;

        String[] temArray = String.valueOf(sumArr.get(0)).split("");
        for(String splitNum : temArray) {
            firSumValue += Integer.valueOf(splitNum);
        }

        temArray = String.valueOf(sumArr.get(1)).split("");
        for(String splitNum : temArray) {
            secSumValue += Integer.valueOf(splitNum);
        }

        return Math.max(firSumValue, secSumValue);

    }

    //Integer형 List가 인자로 들어왔을 때, 곱을 계산하여 큰 값을 리턴
    static private int mul(List<Integer> mulArr) {

        int firMulValue = 1;
        int secMulValue = 1;

        String[] temArray = String.valueOf(mulArr.get(0)).split("");
        for(String splitNum : temArray) {
            firMulValue *= Integer.valueOf(splitNum);
        }

        temArray = String.valueOf(mulArr.get(1)).split("");
        for(String splitNum : temArray) {
            secMulValue *= Integer.valueOf(splitNum);
        }

        return Math.max(firMulValue, secMulValue);

    }

    //해당 solution의 최종 결과를 계산하여 winner에 해당하는 리턴값 제시
    static private int winnerResult(int participant1, int participant2) {
        if(participant1 > participant2) {
            return 1;
        }
        else if(participant1 < participant2) {
            return 2;
        }
        else if(participant1 == participant2) {
            return 0;
        }
        else {
            return -1;
        }
    }

}