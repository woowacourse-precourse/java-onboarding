package onboarding;

import java.util.List;

class Problem1 {

    private static int compareBigNum(int num1, int num2) {
        int bigNum = 0;

        if (num1 > num2) {
            bigNum = num1;
        } else {
            bigNum = num2;
        }
        return bigNum;
    }

    private static int compareAddAndMul(int num) {
        int add = 0;
        int mul = 1;

        while (num != 0) {
            add += num % 10;
            mul *= num % 10;
            num /= 10;
        }

        return compareBigNum(add, mul);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //예외
        if (pobi.get(0) + 1 != pobi.get(1)) {
            return -1;
        } else if (crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;

        //포비와 크롱의 가장 큰 수
        int pobiNum = compareBigNum(compareAddAndMul(pobi.get(0)), compareAddAndMul(pobi.get(1)));
        int crongNum = compareBigNum(compareAddAndMul(crong.get(0)), compareAddAndMul(crong.get(1)));

        //출력값
        if (pobiNum > crongNum) {
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }
}