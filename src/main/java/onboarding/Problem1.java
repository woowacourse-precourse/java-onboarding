package onboarding;

import java.util.List;

class Problem1 {
    public static int calBigNum(int num) {
        if(num / 10 == 0) {
            // 한자리 일 때
            return num;
        } else if(num / 100 == 0) {
            // 두자리 일 때
            int sumNumber = num % 10 + num / 10;
            int mulNumber = (num % 10) * (num / 10);
            return Math.max(sumNumber, mulNumber);
        } else {
            // 세자리 일 때
            int sumNumber = num % 10 + num / 10 + num / 100;
            int mulNumber = (num % 10) * (num / 10) * (num / 100);
            return Math.max(sumNumber, mulNumber);
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = Math.max(calBigNum(pobi.get(0)), calBigNum(pobi.get(1)));
        int crongScore = Math.max(calBigNum(crong.get(0)), calBigNum(crong.get(1)));

        if(pobiScore > crongScore) {
            // pobi 승
            answer = 1;
        } else if(pobiScore < crongScore) {
            // crong 승
            answer = 2;
        } else {
            // 무승부
            answer = 0;
        }

        return answer;
    }
}