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


        return answer;
    }
}