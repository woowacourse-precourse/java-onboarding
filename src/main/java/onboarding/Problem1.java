package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
            return -1;
        }

        int plMax = (calMul(pobi.get(0)) > calSum(pobi.get(0))) ? calMul(pobi.get(0)) : calSum(pobi.get(0));
        int prMax = (calMul(pobi.get(1)) > calSum(pobi.get(1))) ? calMul(pobi.get(1)) : calSum(pobi.get(1));
        int pMax = (plMax > prMax) ? plMax : prMax;

        int clMax = (calMul(crong.get(0)) > calSum(crong.get(0))) ? calMul(crong.get(0)) : calSum(crong.get(0));
        int crMax = (calMul(crong.get(1)) > calSum(crong.get(1))) ? calMul(crong.get(1)) : calSum(crong.get(1));
        int cMax = (clMax > crMax) ? clMax : crMax;

        if (pMax == cMax) {
            return 0;
        } else if (pMax > cMax) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int calMul(int i) {
        int result = 1;
        while (i > 0) {
            result *= i % 10;
            i /= 10;
        }
        return result;
    }

    public static int calSum(int i) {
        int result = 0;
        while (i > 0) {
            result += i % 10;
            i /= 10;
        }
        return result;
    }
}