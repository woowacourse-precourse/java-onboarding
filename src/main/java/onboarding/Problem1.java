package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(exception(pobi) || exception(crong)) answer = -1;

        int pobiMax = Math.max(checkMaxNum(pobi.get(0)), checkMaxNum(pobi.get(1)));
        int crongMax = Math.max(checkMaxNum(crong.get(0)), checkMaxNum(crong.get(1)));

        if(pobiMax > crongMax) answer = 1;
        else if(pobiMax < crongMax) answer = 2;
        else answer = 0;

        return answer;
    }

    static int checkMaxNum(int num) {
        int sum = 0;
        int mul = 1;

        while(num > 0) {
            sum += num % 10;
            mul *= num% 10;
            num /= 10;
        }

        return Math.max(sum, mul);
    }

    static boolean exception(List<Integer> list) {
        boolean answer = false;

        if(list.get(0) < 1 || list.get(1) > 400) answer = true;
        if(list.get(1) - list.get(0) != 1) answer = true;
        if(list.get(0) % 2 == 0) answer = true;
        if(list.size() != 2) answer = true;

        return answer;
    }
}