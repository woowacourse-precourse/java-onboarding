package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int clapCount = 0;

        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            clapCount += getClapCount(currentNumber);
        }

        return clapCount;
    }

    private static int getClapCount(int currentNumber) {
        int temp = 0;
        while(currentNumber > 0) {
            if(isContainClapNumber(currentNumber)){
                temp++;
            };
            currentNumber /= 10;
        }
        return temp;
    }

    private static boolean isContainClapNumber(int currentNumber) {
        List<Integer> clapList = List.of(3,6,9);
        return clapList.contains(currentNumber % 10);
    }

}
