package onboarding;

import java.util.Arrays;
import java.util.List;

/*
*   구현 기능
*   1. 페이지수를 각 자릿수별로 분할하는 기능
*   2. 각 자릿수를 더하는 기능
*   3. 각 자릿수를 곱하는 기능
*   4. 최대값 탐색 기능
*   5. 예외사항 탐색 기능
*   6. 1~4번 기능을 이용한 처리로직을 담당하는 모듈
*/
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobimax; int crongmax;

        if(!isNormal(pobi) || !isNormal(crong)){
            answer = -1;
            return answer;
        }

        pobimax = pipeline(pobi);
        crongmax = pipeline(crong);

        if(pobimax == crongmax){
            answer = 0;
        } else if (pobimax > crongmax) {
            answer = 1;
        } else if (pobimax < crongmax) {
            answer = 2;
        }

        return answer;
    }

    public static int getSum(List<Integer> numbers) {
        int result = 0;
        result += numbers.get(0) + numbers.get(1) + numbers.get(2);

        return result;
    }

    public static int getMulti(List<Integer> numbers) {
        int result = 1;
        if(numbers.get(0) == 0) {
            if(numbers.get(1) == 0){        // 백의자리 0 && 십의자리 0
                result = numbers.get(2);
            } else {                        // 백의자리만 0
                result *= numbers.get(1) * numbers.get(2);
            }
        }
        else if(numbers.get(1) == 0) {
            if(numbers.get(2) == 0){        // 십의자리 0 && 일의자리 0
                result = numbers.get(0);
            } else {                        // 십의자리만 0
                result *= numbers.get(0) * numbers.get(2);
            }
        }
        else {                              // 0 없음
            result *= numbers.get(0) * numbers.get(1) * numbers.get(2);
        }

        return result;
    }

    public static int getMax(List<Integer> numbers) {
        int max = 0;
        for(Integer num : numbers) {
            if (max < num) {
                max = num;
            }
        }

        return max;
    }

    public static boolean isNormal(List<Integer> list) {
        int diff = list.get(1) - list.get(0);
        return diff == 1 && list.get(0) % 2 == 1 && list.get(0) > 0 && list.get(1) < 401;
    }

    public static int pipeline(List<Integer> list) {
        int result = 0;
        List<Integer> splitnumL;
        List<Integer> splitnumR;
        NumSpliter numSpliter = new NumSpliter();
        Integer[] numarr = new Integer[4];

        splitnumL = numSpliter.splitNum(list.get(0));
        splitnumR = numSpliter.splitNum(list.get(1));

        numarr[0] = getSum(splitnumL);
        numarr[1] = getMulti(splitnumL);
        numarr[2] = getSum(splitnumR);
        numarr[3] = getMulti(splitnumR);
        result = getMax(Arrays.asList(numarr));

        return result;
    }
}

class NumSpliter {
    public List<Integer> splitNum(Integer num) {
        int numOfFirst;
        int numOfSecond;
        int numOfThird;
        numOfFirst = num / 100;
        numOfSecond = (num % 100) / 10;
        numOfThird = num % 10;

        return List.of(numOfFirst, numOfSecond, numOfThird);
    }
}

class MaxFinder {

}