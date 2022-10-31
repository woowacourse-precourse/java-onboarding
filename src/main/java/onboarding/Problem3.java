package onboarding;

public class Problem3 {
    public static int solution(int number) {
        validate(number);
        int digitCnt = getDigitCnt(number);
        int totalCnt = calculateAllClapCntAboutThisDigit(digitCnt);
        for (int i = number + 1; i < (int) Math.pow(10, digitCnt); i++) {
            totalCnt -= calculateClapCnt(i);
        }
        return totalCnt;
    }

    private static void validate(int number) {
        if(number < 1 || number > 10000) {
            System.out.println("number가 범위를 벗어났습니다");
        }
    }

    private static int calculateClapCnt(int number) {
        int clapCnt = 0;
        while (number > 0) {
            int digitNum = number % 10;
            if(digitNum == 3 || digitNum == 6 || digitNum == 9) {
                clapCnt += 1;
            }
            number /= 10;
        }
        return clapCnt;
    }

    private static int calculateAllClapCntAboutThisDigit(int digitCnt) {
        int totalCnt = 0;
        for (int i = 0; i < digitCnt; i++) {
            if(i == 0) {
                totalCnt += 3;
                continue;
            }
            totalCnt = totalCnt * 9 + (int) Math.pow(10,i) * 3 + totalCnt;
        }
        return totalCnt;
    }

    //number의 자릿수를 계산한다
    private static int getDigitCnt(int number) {
        int digitCnt = 0;
        while(number > 0) {
            number /= 10;
            digitCnt += 1;
        }
        return digitCnt;
    }
}
