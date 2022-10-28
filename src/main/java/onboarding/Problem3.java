package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countingClapCount(number);
    }

    static int countingClapCount(int endNum) {
        int clapCount = 0;
        for (int eachNum = 1; eachNum <= endNum; eachNum++) {
            clapCount += countingNumberThreeSixNine(eachNum);
        }
        return clapCount;
    }

    static int countingNumberThreeSixNine(int num) {
        int countedNum = 0;
        while (num > 0) {
            if (isThreeSixNine(num)) countedNum++;
            num /= 10;
        }
        return countedNum;
    }

    static boolean isThreeSixNine(int num) {
        return (num % 10) == 3 || (num % 10) == 6 || (num % 10) == 9;
    }
}
