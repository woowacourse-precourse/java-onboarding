package onboarding;

import java.util.List;

class Problem1 {
    public static boolean checkList(List<Integer> list) {
        return ((list.get(0) % 2 == 1) && (list.get(0) + 1 == list.get(1)) && 1 < (list.get(0)) && (list.get(0) < 399));
    }

    public static int calculate(int page) {
        int num = page;
        int rest;
        int plus = 0;
        int multi = 1;
        int result;

        while (num > 0) {
            rest = num % 10;
            plus += rest;
            multi *= rest;
            num = num / 10;
        }
        result = Math.max(plus, multi);
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = 0;
        int crongMax = 0;

        if (checkList(pobi) && checkList(crong)) {
            pobiMax = Math.max(calculate(pobi.get(0)), calculate(pobi.get(1)));
            crongMax = Math.max(calculate(crong.get(0)), calculate(crong.get(1)));

            if (pobiMax > crongMax)
                answer = 1;
            else if (pobiMax < crongMax)
                answer = 2;
            else
                answer = 0;
        }
        else
            answer = -1;

        return answer;
    }
}