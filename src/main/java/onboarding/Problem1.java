package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if ((pobi.get(1) != pobi.get(0) + 1) || (crong.get(1) != crong.get(0) + 1)) {
            return -1;
        }

        int finalPobiNum = bigOne(bigOne(addNum(pobi.get(0)), muxNum(pobi.get(0))), bigOne(addNum(pobi.get(1)), muxNum(pobi.get(1))));
        int finalCrongNum = bigOne(bigOne(addNum(crong.get(0)), muxNum(crong.get(0))), bigOne(addNum(crong.get(1)), muxNum(crong.get(1))));

        if (finalPobiNum > finalCrongNum) return 1;
        else if (finalPobiNum < finalCrongNum) return 2;
        else return 0;

    }
    private static int addNum(int num) {
        return (num/100) + (num%100/10) + (num%100%10);
    }
    private static int muxNum(int num) {
        if(num >= 100) {
            return (num/100) * (num%100/10) * (num%100%10);
        } else if(num >= 10) {
            return (num/10) * (num%10);
        } else return num;
    }
    private static int bigOne(int num1, int num2) {
        return Math.max(num1, num2);
    }
}