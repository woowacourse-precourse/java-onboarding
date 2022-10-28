package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countingClapCount(number);
    }

    static int countingClapCount(int endNum) {
        int clapCount = 0;
        for (int eachNum = 0; eachNum < endNum; eachNum++) {
            clapCount += countingNumberThreeSixNine(eachNum);
        }
        return clapCount;
    }

    static int countingNumberThreeSixNine(int number) {
        int countedNumber = 0;
        while (number > 0) {
            if (isThreeSixNine(number)) countedNumber++;
            number /= 10;
        }
        return countedNumber;
    }

    static boolean isThreeSixNine(int number) {
        return (number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9;
    }
}
