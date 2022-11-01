package onboarding;

import java.util.List;

class Problem1 {
    public static int adder(int page) {
        int sum = 0;
        int quotient = page;

        while(quotient > 9) {
            sum += quotient % 10;
            quotient /= 10;
        }
        sum += quotient;
        return sum;
    }

    public static int multiplier(int page) {
        int sum = 1;
        int quotient = page;

        while(quotient > 9) {
            sum *= quotient % 10;
            quotient /= 10;
        }
        sum *= quotient;
        return sum;
    }

    public static int getBiggest(int page1, int page2) {
        int score1 = Math.max(adder(page1), multiplier(page1));
        int score2 = Math.max(adder(page2), multiplier(page2));
        return Math.max(score1, score2);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return answer;

        int pobiScore = getBiggest(pobi.get(0), pobi.get(1));
        int crongScore = getBiggest(crong.get(0), crong.get(1));

        if(pobiScore > crongScore) return 1;
        else if(pobiScore < crongScore) return 2;
        else return 0;
    }
}