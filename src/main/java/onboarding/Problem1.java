package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        int scoreOfPobi = getBigNumber(pobi);
        int scoreOfCrong = getBigNumber(crong);
        if (scoreOfPobi == scoreOfCrong) {
            answer = 0;
        }
        if (scoreOfPobi > scoreOfCrong) {
            answer = 1;
        }
        if (scoreOfPobi < scoreOfCrong) {
            answer = 2;
        }
        if ((scoreOfPobi == -1) || (scoreOfCrong == -1)) {
            answer = -1;
        }
        return answer;
    }

    public static int getBigNumber(List<Integer> inputList) {
        List<Integer> numList = new ArrayList<>();
        List<String> singleDigitArr;
        int sumNumber;
        int multiplyNumber;

        for (Integer integer : inputList) {
            if (inputList.get(1) - inputList.get(0) != 1 || integer == 1 || integer >= 400) {
                return -1;
            }
            singleDigitArr = List.of(integer.toString().split(""));
            sumNumber = 0;
            multiplyNumber = 1;
            for (String singleDigit : singleDigitArr) {
                sumNumber += parseInt(singleDigit);
                multiplyNumber *= parseInt(singleDigit);
            }
            numList.add(sumNumber);
            numList.add(multiplyNumber);
        }
        return Collections.max(numList);
    }
}