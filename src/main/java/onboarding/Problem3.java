package onboarding;

public class Problem3 {
    /* 기능 단위
     * 1. 자릿수와 자릿수에 따른 10의 거듭제곱 구하기 (getDigit, getPowerByDigit)
     *   a. ex) 234 -> 자릿수: 3, 자릿수에 따른 10의 거듭제곱: 100
     * 2. 자릿수에 따른 손뼉 수 구하기 (getClapByDigit)
     *   a. 아래 알고리즘을 따름
     *   b. clap[i] = clap[i-1] + clap[i-1]*9 + (int) Math.pow(10, i)*3
     * 3. 1부터 number까지 손뼉 수 구하기 (getClapByNumber)
     * */

    private static int getDigit(int number) {
        return (int) (Math.log10(number)+1);
    }

    private static int getPowerByDigit(int digit) {
        return ((int) Math.pow(10, digit-1));
    }

    private static int[] getClapByDigit(int digit) {
        int[] clap = new int[digit];
        int i = 0;
        while (i < digit) {
            if(i == 0) clap[i] = 3;
            else clap[i] = clap[i-1] + clap[i-1]*9 + (int) Math.pow(10, i)*3;
            i ++;
        }
        return clap;
    }

    private static int getClapByNumber(int number, int[] clap) {
        System.out.printf("Target Number: %d\n", number);
        int digit, digitNum, remainder; // ex) 582 -> 자릿수(3), 해당 자릿수에 해당하는 숫자(5), 나머지(82)
        int clapNum = 0; // 손뼉횟수

        if (number < 10) return number/3;
        else {
            digit = getDigit(number);
            digitNum = number / getPowerByDigit(digit);
            clapNum += (digitNum-1) * clap[digit-1-1];
            clapNum += ((digitNum-1)/3) * getPowerByDigit(digit);
            remainder = (number % getPowerByDigit(digit));
            if (digitNum % 3 == 0) {
                clapNum += remainder+1;
            }
            System.out.printf("clapNum: %d\n", clapNum);
            return clapNum + getClapByNumber(remainder, clap);
        }
    }

    public static int solution(int number) {
        int answer = 0;
        System.out.println("==================");
        int[] clap = getClapByDigit(number);
        answer = getClapByNumber(number, clap);
        int digit = getDigit(number);
        for(int i=digit-1; i>0; i--) {
            answer += clap[i-1];
        }
        return answer;
    }
}
